package com.example.nutritionfacts.ui.viewStates

import com.example.domain.models.GroceryFood

sealed class GroceryFoodViewState {

    object LOADING : GroceryFoodViewState()

    object ERROR : GroceryFoodViewState()

    data class GroceryFoodDataLoaded(val groceryFoodDataList: List<GroceryFood>): GroceryFoodViewState()

}