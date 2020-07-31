package com.example.domain.repositories

import com.example.domain.models.GroceryFood
import io.reactivex.rxjava3.core.Single

interface GroceryFoodRepository {
    fun getGroceryFoodData(
        id: String,
        key: String,
        groceryIngredient: String
    ): Single<List<GroceryFood>>
}