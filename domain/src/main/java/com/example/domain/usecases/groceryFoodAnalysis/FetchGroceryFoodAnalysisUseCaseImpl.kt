package com.example.domain.usecases.groceryFoodAnalysis

import com.example.domain.models.GroceryFood
import com.example.domain.repositories.GroceryFoodRepository
import io.reactivex.rxjava3.core.Single

class FetchGroceryFoodAnalysisUseCaseImpl (private val groceryFoodRepo: GroceryFoodRepository): FetchGroceryFoodAnalysisUseCase {
    override fun fetchGroceryFoodData(
        id: String,
        key: String,
        groceryIngredient: String
    ): Single<List<GroceryFood>> {
       return groceryFoodRepo.getGroceryFoodData(id,key,groceryIngredient)
    }
}