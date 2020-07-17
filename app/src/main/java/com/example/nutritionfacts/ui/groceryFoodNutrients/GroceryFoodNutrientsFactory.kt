package com.example.nutritionfacts.ui.groceryFoodNutrients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository.GroceryFoodNutrientsRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class GroceryFoodNutrientsFactory @Inject constructor(
    private val groceryFoodNutrientsRepository: GroceryFoodNutrientsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GroceryFoodNutrientsViewModel::class.java)) {
            return GroceryFoodNutrientsViewModel(groceryFoodNutrientsRepository) as T
        }
        throw IllegalArgumentException("ViewModel was not found")
    }
}