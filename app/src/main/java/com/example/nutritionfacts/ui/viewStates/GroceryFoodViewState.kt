package com.example.nutritionfacts.ui.viewStates

import com.example.nutritionfacts.ui.models.GroceryFood

sealed class GroceryFoodViewState {

    object LOADING : GroceryFoodViewState()

    object ERROR : GroceryFoodViewState()

    data class GroceryFoodDataLoaded(val groceryFoodDataList: List<GroceryFood>): GroceryFoodViewState()

}