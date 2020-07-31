package com.example.nutritionfacts.ui.groceryFoodAnalysis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.provider.LanguageProvider
import com.example.nutritionfacts.App
import com.example.data.provider.LanguageProviderImpl
import com.example.domain.usecases.groceryFoodAnalysis.FetchGroceryFoodAnalysisUseCase
import com.example.domain.usecases.translateRequestText.TranslateTextUseCase
import com.example.nutritionfacts.ui.viewStates.GroceryFoodViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class GroceryFoodAnalysisViewModel(
    private val fetchGroceryFoodDataUseCase: FetchGroceryFoodAnalysisUseCase,
    private val translateTextUseCase: TranslateTextUseCase
) : ViewModel() {

    private val id = "92ae2871"
    private val key = "167c9bb5ea6b17f70c5d33318c9f1fa0"

    private var disposable: Disposable? = null

    private val languageProvider: LanguageProvider =
        LanguageProviderImpl(App.context.applicationContext)
    private val language = languageProvider.getLanguageProvider()

    private val _groceryFoodData = MutableLiveData<GroceryFoodViewState>()
    val groceryFoodData: LiveData<GroceryFoodViewState> get() = _groceryFoodData

    private fun fetchGroceryFoodData(ingredient: String) {
        _groceryFoodData.value = GroceryFoodViewState.LOADING

        disposable?.dispose()

        disposable = Single.just(ingredient)
            .subscribeOn(Schedulers.io())
            .flatMap {
                if (language.value == "ru-en") {
                    translateTextUseCase.translateText(it, language.value)
                } else {
                    Single.just(ingredient)
                }
            }
            .flatMap { fetchGroceryFoodDataUseCase.fetchGroceryFoodData(id, key, it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _groceryFoodData.value = GroceryFoodViewState.GroceryFoodDataLoaded(it)
                if (it.isEmpty()) _groceryFoodData.value = GroceryFoodViewState.ERROR
            },
                {
                    _groceryFoodData.value = GroceryFoodViewState.ERROR
                    Log.i("ERROR", "error = ${it.printStackTrace()}")
                })
    }

    fun enteredIngredient(ingredient: String) {
        fetchGroceryFoodData(ingredient)
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}