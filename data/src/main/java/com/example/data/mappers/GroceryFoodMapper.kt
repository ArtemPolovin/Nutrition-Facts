package com.example.data.mappers

import com.example.data.modulsApi.groceryFoodResponse.GroceryFoodApi
import com.example.domain.models.GroceryFood

class GroceryFoodMapper {
    fun mapToList(groceryFoodApi: GroceryFoodApi): List<GroceryFood> {
        val list = mutableListOf<GroceryFood>()
        for ((index, element) in groceryFoodApi.hints.withIndex()) {
            list.add(GroceryFood(
                element.food.label,
                element.food.brand,
                element.food.image,
                element.measures[0].uri,
                element.food.foodId
            ))
        }
        return list
    }
}