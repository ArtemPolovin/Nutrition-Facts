package com.example.nutritionfacts.data.repository.response.groceryFoodResponse

data class FoodX(
    val category: String,
    val categoryLabel: String,
    val foodId: String,
    val image: String,
    val label: String,
    val nutrients: NutrientsX
)