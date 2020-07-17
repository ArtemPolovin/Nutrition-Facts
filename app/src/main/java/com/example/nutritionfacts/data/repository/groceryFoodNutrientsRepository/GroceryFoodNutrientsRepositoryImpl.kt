package com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository

import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.data.repository.pojo.GroceryFoodPojo
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import com.example.nutritionfacts.mapp.GroceryFoodNutrientsMapper
import com.example.nutritionfacts.ui.models.FoodAnalysis
import com.example.nutritionfacts.ui.models.GroceryFoodNutrients
import io.reactivex.rxjava3.core.Single

class GroceryFoodNutrientsRepositoryImpl(
    private val apiService: NutritionAnalysisApiService,
    private val mapper: GroceryFoodNutrientsMapper
) : GroceryFoodNutrientsRepository {

    override fun getGroceryFoodNutrients(
        id: String,
        key: String,
        groceryFoodNutrientsPojoList: GroceryFoodPojo
    ): Single<GroceryFoodNutrients> {
     return   apiService.getGroceryFoodNutrients(id,key,groceryFoodNutrientsPojoList)
            .map { mapper.mapToNutrientsAnalysis(it) }
    }
}