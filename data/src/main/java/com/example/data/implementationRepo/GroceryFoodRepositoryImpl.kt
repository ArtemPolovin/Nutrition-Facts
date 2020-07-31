package com.example.data.implementationRepo

import com.example.data.network.retrofit.NutritionAnalysisApiService
import com.example.data.mappers.GroceryFoodMapper
import com.example.domain.models.GroceryFood
import com.example.domain.repositories.GroceryFoodRepository
import io.reactivex.rxjava3.core.Single

class GroceryFoodRepositoryImpl(
    private val apiService: NutritionAnalysisApiService,
    private val mapper: GroceryFoodMapper
): GroceryFoodRepository {

    override fun getGroceryFoodData(
        id: String,
        key: String,
        groceryIngredient: String
    ): Single<List<GroceryFood>> {
      return  apiService.getGroceryFoodData(id,key,groceryIngredient)
            .map{mapper.mapToList(it)}
    }
}