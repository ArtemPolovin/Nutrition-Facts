package com.example.nutritionfacts.ui.groceryFoodNutrients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.repositories.GroceryFoodNutrientsRepository
import com.example.domain.usecases.groceryFoodNutrients.FetchGroceryFoodNutrientsUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class GroceryFoodNutrientsFactory @Inject constructor(
    private val fetchGroceryFoodNutrientsUseCase: FetchGroceryFoodNutrientsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GroceryFoodNutrientsViewModel::class.java)) {
            return GroceryFoodNutrientsViewModel(fetchGroceryFoodNutrientsUseCase) as T
        }
        throw IllegalArgumentException("ViewModel was not found")
    }
}