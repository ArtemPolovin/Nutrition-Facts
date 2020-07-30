package com.example.nutritionfacts.ui.groceryFoodAnalysis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionfacts.data.repository.groceryFoodRepository.GroceryFoodRepository
import com.example.nutritionfacts.data.repository.translateRepository.TranslateRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class GroceryFoodFactory @Inject constructor(
    private val groceryFoodRepository: GroceryFoodRepository,
    private val translateRepository: TranslateRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GroceryFoodAnalysisViewModel::class.java)) {
            return GroceryFoodAnalysisViewModel(groceryFoodRepository, translateRepository) as T
        }
        throw IllegalArgumentException("ViewModel was not found")
    }
}