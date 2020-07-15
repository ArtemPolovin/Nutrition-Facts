package com.example.nutritionfacts.mapp

import com.example.nutritionfacts.data.repository.response.groceryFoodResponse.GroceryFoodApi
import com.example.nutritionfacts.ui.models.GroceryFood

class GroceryFoodMapper {
    fun mapToList(groceryFoodApi: GroceryFoodApi): List<GroceryFood> {
        val list = mutableListOf<GroceryFood>()
        for ((index, element) in groceryFoodApi.hints.withIndex()) {
            list.add(GroceryFood(
                element.food.label,
                element.food.servingSizes?.get(0)?.quantity?.toInt().toString(),
                element.food.servingSizes?.get(0)?.label,
                element.food.nutrients.ENERC_KCAL.toInt().toString(),
                element.food.brand,
                element.food.image,
                element.measures[0].uri,
                element.food.foodId
            ))
        }
        return list
    }
}