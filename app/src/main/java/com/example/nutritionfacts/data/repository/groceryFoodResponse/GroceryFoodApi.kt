package com.example.nutritionfacts.data.repository.groceryFoodResponse

data class GroceryFoodApi(
    val _links: Links,
    val hints: List<Hint>,
    val parsed: List<Parsed>,
    val text: String
)