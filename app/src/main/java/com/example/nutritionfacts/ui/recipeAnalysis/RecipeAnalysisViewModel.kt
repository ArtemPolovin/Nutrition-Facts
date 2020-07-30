package com.example.nutritionfacts.ui.recipeAnalysis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nutritionfacts.App
import com.example.nutritionfacts.data.provider.LanguageProvider
import com.example.nutritionfacts.data.provider.LanguageProviderImpl
import com.example.nutritionfacts.data.repository.pojo.RecipeAnalysisPojo
import com.example.nutritionfacts.data.repository.recipeAnalysisRepository.RecipeAnalysisRepository
import com.example.nutritionfacts.data.repository.translateRepository.TranslateRepository
import com.example.nutritionfacts.ui.viewStates.FoodAnalysisViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RecipeAnalysisViewModel(
    private val recipeAnalysisRepository: RecipeAnalysisRepository,
    private val translateRepository: TranslateRepository
) : ViewModel() {

    private val id = "34cc042c"
    private val key = "fd7b0a01c554ecad3cffd0a081e38235"

    private var disposable: Disposable? = null

    val recipeList: MutableLiveData<MutableList<String>> =
        MutableLiveData<MutableList<String>>().apply { value?.add("") }

    private val languageProvider: LanguageProvider =
        LanguageProviderImpl(App.context.applicationContext)
    private val language = languageProvider.getLanguageProvider()

    private val _recipeAnalysisViewState = MutableLiveData<FoodAnalysisViewState>()
    val recipeAnalysisViewState: LiveData<FoodAnalysisViewState> get() = _recipeAnalysisViewState

    private fun fetchRecipeAnalysis(recipeLineList: List<String>) {

        _recipeAnalysisViewState.value = FoodAnalysisViewState.Loading

        disposable?.dispose()


        disposable = Observable.fromIterable(recipeLineList)
            .subscribeOn(Schedulers.io())
            .map {
                if (language.value == "ru-en")
                    translateRepository.translate(it, language.value).blockingGet()
                else it
            }
            .buffer(recipeLineList.size)
            .flatMap {
                recipeAnalysisRepository.getRecipeAnalysisData(
                    id,
                    key,
                    RecipeAnalysisPojo(it)
                )
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _recipeAnalysisViewState.value = FoodAnalysisViewState.FoodAnalysisLoaded(it)
                },
                {
                    _recipeAnalysisViewState.value = FoodAnalysisViewState.Error
                    Log.i("Query error", "ERROR = ${it.printStackTrace()}")
                })
    }

    fun enteredRecipe(recipeLineList: List<String>) {
        fetchRecipeAnalysis(recipeLineList)
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}