package com.example.nutritionfacts.data.repository.foodAnalysisRepository

import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import com.example.nutritionfacts.ui.models.FoodAnalysis
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class FoodAnalysisRepositoryIml @Inject constructor(
    private val nutritionAnalysisApiService: NutritionAnalysisApiService,
    private val foodAnalysisMapper: FoodAnalysisMapper
) : FoodAnalysisRepository {


    override fun getFoodAnalysisData(ingredient: String): Single<FoodAnalysis> {
        return nutritionAnalysisApiService.getFoodAnalysis(ingredient)
            .map { foodAnalysisMapper.mapToFoodAnalysis(it) }

    }

}