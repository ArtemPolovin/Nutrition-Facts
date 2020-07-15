package com.example.nutritionfacts.data.repository.groceryFoodRepository

import com.example.nutritionfacts.ui.models.GroceryFood
import io.reactivex.rxjava3.core.Single

interface GroceryFoodRepository {
    fun getGroceryFoodData(
        id: String,
        key: String,
        groceryIngredient: String
    ): Single<List<GroceryFood>>
}