package com.example.data.implementationRepo

import com.example.data.network.retrofit.NutritionAnalysisApiService
import com.example.data.mappers.FoodAnalysisMapper
import com.example.domain.models.FoodAnalysis
import com.example.domain.repositories.FoodAnalysisRepository
import io.reactivex.rxjava3.core.Single


class FoodAnalysisRepositoryIml (
    private val nutritionAnalysisApiService: NutritionAnalysisApiService,
    private val foodAnalysisMapper: FoodAnalysisMapper
) : FoodAnalysisRepository {


    override fun getFoodAnalysisData(id: String, key: String, ingredient: String): Single<FoodAnalysis> {
        return nutritionAnalysisApiService.getFoodAnalysis(id, key, ingredient)
            .map { foodAnalysisMapper.mapToFoodAnalysis(it) }

    }

}