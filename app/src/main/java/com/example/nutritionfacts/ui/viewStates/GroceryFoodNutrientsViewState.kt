package com.example.nutritionfacts.ui.viewStates

import com.example.domain.models.GroceryFoodNutrients

sealed class GroceryFoodNutrientsViewState {

    object Loading : GroceryFoodNutrientsViewState()

    object Error: GroceryFoodNutrientsViewState()

    data class GroceryFoodLoaded(val groceryFoodNutrients: GroceryFoodNutrients): GroceryFoodNutrientsViewState()
}