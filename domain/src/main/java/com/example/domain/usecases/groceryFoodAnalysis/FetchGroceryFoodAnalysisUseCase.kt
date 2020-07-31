package com.example.domain.usecases.groceryFoodAnalysis

import com.example.domain.models.GroceryFood
import io.reactivex.rxjava3.core.Single

interface FetchGroceryFoodAnalysisUseCase {
    fun fetchGroceryFoodData(
        id: String,
        key: String,
        groceryIngredient: String
    ): Single<List<GroceryFood>>
}