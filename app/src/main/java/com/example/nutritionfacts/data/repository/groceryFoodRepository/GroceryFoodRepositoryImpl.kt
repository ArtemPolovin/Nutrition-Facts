package com.example.nutritionfacts.data.repository.groceryFoodRepository

import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.GroceryFoodMapper
import com.example.nutritionfacts.ui.models.GroceryFood
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