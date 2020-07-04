package com.example.nutritionfacts.ui.foodTextAnalysis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionfacts.data.repository.foodAnalysisRepository.FoodAnalysisRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class FoodAnalysisFactory @Inject constructor(
   private val foodAnalysisRepository: FoodAnalysisRepository
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodAnalysisViewModel::class.java)) {
            return FoodAnalysisViewModel(foodAnalysisRepository) as T
        }
        throw IllegalArgumentException("ViewModel class is not found")
    }

}