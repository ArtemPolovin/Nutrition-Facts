package com.example.nutritionfacts.ui.foodTextAnalysis

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionfacts.data.repository.foodAnalysisRepository.FoodAnalysisRepository
import com.example.nutritionfacts.data.repository.translateRepository.TranslateRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class FoodAnalysisFactory @Inject constructor(
    private val foodAnalysisRepository: FoodAnalysisRepository,
    private val translateRepository: TranslateRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodAnalysisViewModel::class.java)) {
            return FoodAnalysisViewModel(foodAnalysisRepository,translateRepository) as T
        }
        throw IllegalArgumentException("ViewModel class is not found")
    }

}