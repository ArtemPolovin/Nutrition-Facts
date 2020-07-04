package com.example.nutritionfacts.ui.viewStates

import com.example.nutritionfacts.ui.models.FoodAnalysis

sealed class FoodAnalysisViewState {

    object Loading : FoodAnalysisViewState()

    object Error: FoodAnalysisViewState()

    data class FoodAnalysisLoaded(val foodAnalysis: FoodAnalysis): FoodAnalysisViewState()

}