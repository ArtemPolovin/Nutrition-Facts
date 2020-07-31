package com.example.nutritionfacts.ui.foodTextAnalysis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.provider.LanguageProvider
import com.example.nutritionfacts.App
import com.example.data.provider.LanguageProviderImpl
import com.example.domain.usecases.foodTextAnalysis.FetchFoodAnalysisUseCase
import com.example.domain.usecases.translateRequestText.TranslateTextUseCase
import com.example.nutritionfacts.ui.viewStates.FoodAnalysisViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class FoodAnalysisViewModel(
    private val fetchFoodAnalysisUseCase: FetchFoodAnalysisUseCase,
    private val translateUseCase: TranslateTextUseCase
) : ViewModel() {

    private val id = "34cc042c"
    private val key = "fd7b0a01c554ecad3cffd0a081e38235"

    private val languageProvider: LanguageProvider =
        LanguageProviderImpl(App.context.applicationContext)
    private val language = languageProvider.getLanguageProvider()

    private val _foodAnalysisViewState = MutableLiveData<FoodAnalysisViewState>()
    val foodAnalysisViewState: LiveData<FoodAnalysisViewState> get() = _foodAnalysisViewState

    private var disposable: Disposable? = null

    private fun fetchFoodAnalysisData(ingredient: String) {

        _foodAnalysisViewState.value = FoodAnalysisViewState.Loading

        disposable?.dispose()

        disposable = Single.just(ingredient)
            .subscribeOn(Schedulers.io())
            .flatMap {
                if (language.value == "ru-en") {
                    translateUseCase.translateText(it, language.value)
                } else {
                    Single.just(ingredient)
                }
            }
            .flatMap {fetchFoodAnalysisUseCase.fetchFoodAnalysisData(id, key, it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _foodAnalysisViewState.value = FoodAnalysisViewState.FoodAnalysisLoaded(it)
                },
                {
                    _foodAnalysisViewState.value = FoodAnalysisViewState.Error
                    Log.i("Query error", "ERROR = ${it.printStackTrace()}")
                }
            )
    }

    fun getFoodAnalysis(ingredient: String) {
        fetchFoodAnalysisData(ingredient)
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}