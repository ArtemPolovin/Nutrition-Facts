package com.example.nutritionfacts.ui.foodTextAnalysis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.repositories.FoodAnalysisRepository
import com.example.domain.repositories.TranslateRepository
import com.example.domain.usecases.foodTextAnalysis.FetchFoodAnalysisUseCase
import com.example.domain.usecases.translateRequestText.TranslateTextUseCase
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class FoodAnalysisFactory @Inject constructor(
    private val fetchFoodAnalysisUseCase: FetchFoodAnalysisUseCase,
    private val translateUseCase: TranslateTextUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodAnalysisViewModel::class.java)) {
            return FoodAnalysisViewModel(fetchFoodAnalysisUseCase,translateUseCase) as T
        }
        throw IllegalArgumentException("ViewModel class is not found")
    }

}