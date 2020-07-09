package com.example.nutritionfacts.ui.foodTextAnalysis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nutritionfacts.data.repository.foodAnalysisRepository.FoodAnalysisRepository
import com.example.nutritionfacts.ui.viewStates.FoodAnalysisViewState
import com.example.nutritionfacts.ui.viewStates.WelcomeScreenViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class FoodAnalysisViewModel(
    private val foodAnalysisRepository: FoodAnalysisRepository
) : ViewModel() {

    private val _foodAnalysisViewState = MutableLiveData<FoodAnalysisViewState>()
    val foodAnalysisViewState: LiveData<FoodAnalysisViewState> get() = _foodAnalysisViewState

    private var disposable: Disposable? = null

    private fun fetchFoodAnalysisData(ingredient: String) {

        _foodAnalysisViewState.value = FoodAnalysisViewState.Loading

        disposable?.dispose()
        disposable = foodAnalysisRepository.getFoodAnalysisData(ingredient)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _foodAnalysisViewState.value = FoodAnalysisViewState.FoodAnalysisLoaded(it)
                },
                {
                    _foodAnalysisViewState.value = FoodAnalysisViewState.Error
                    Log.i("Query error", "ERROR = ${it.localizedMessage}")
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