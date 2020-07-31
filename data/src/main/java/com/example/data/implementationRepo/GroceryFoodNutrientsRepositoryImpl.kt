package com.example.data.implementationRepo

import com.example.data.network.retrofit.NutritionAnalysisApiService
import com.example.data.mappers.GroceryFoodNutrientsMapper
import com.example.domain.repositories.pojo.GroceryFoodPojo
import com.example.domain.models.GroceryFoodNutrients
import com.example.domain.repositories.GroceryFoodNutrientsRepository
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