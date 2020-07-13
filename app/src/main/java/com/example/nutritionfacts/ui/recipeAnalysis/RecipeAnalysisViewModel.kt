package com.example.nutritionfacts.ui.recipeAnalysis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nutritionfacts.data.repository.pojo.RecipeAnalysisPojo
import com.example.nutritionfacts.data.repository.recipeAnalysisRepository.RecipeAnalysisRepository
import com.example.nutritionfacts.ui.viewStates.FoodAnalysisViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RecipeAnalysisViewModel(
    private val recipeAnalysisRepository: RecipeAnalysisRepository
): ViewModel() {

    private val disposable: Disposable? = null

    private val _recipeAnalysisViewState = MutableLiveData<FoodAnalysisViewState>()
    val recipeAnalysisViewState: LiveData<FoodAnalysisViewState> get() = _recipeAnalysisViewState

    private fun fetchRecipeAnalysis(recipeAnalysisPojo: RecipeAnalysisPojo) {

        disposable?.dispose()
        _recipeAnalysisViewState.value = FoodAnalysisViewState.Loading

        recipeAnalysisRepository.getRecipeAnalysisData(recipeAnalysisPojo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _recipeAnalysisViewState.value = FoodAnalysisViewState.FoodAnalysisLoaded(it)
                },
                {
                    _recipeAnalysisViewState.value = FoodAnalysisViewState.Error
                    Log.i("Query error", "ERROR = ${it.localizedMessage}")
                }
            )
    }

    fun enteredRecipe(recipeAnalysisPojo: RecipeAnalysisPojo) {
        fetchRecipeAnalysis(recipeAnalysisPojo)
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}