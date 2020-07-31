package com.example.nutritionfacts.ui.viewStates

import com.example.domain.models.FoodAnalysis

sealed class FoodAnalysisViewState {

    object Loading : FoodAnalysisViewState()

    object Error: FoodAnalysisViewState()

    data class FoodAnalysisLoaded(val foodAnalysis: FoodAnalysis): FoodAnalysisViewState()

}