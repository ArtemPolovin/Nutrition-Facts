package com.example.nutritionfacts.ui.groceryFoodAnalysis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionfacts.data.repository.groceryFoodRepository.GroceryFoodRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class GroceryFoodFactory @Inject constructor(
   private val groceryFoodRepository: GroceryFoodRepository
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GroceryFoodAnalysisViewModel::class.java)) {
            return GroceryFoodAnalysisViewModel(groceryFoodRepository) as T
        }
        throw IllegalArgumentException("ViewModel was not found")
    }
}