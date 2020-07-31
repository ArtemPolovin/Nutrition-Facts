package com.example.data.implementationRepo

import com.example.data.network.retrofit.NutritionAnalysisApiService
import com.example.data.mappers.FoodAnalysisMapper
import com.example.domain.models.FoodAnalysis
import com.example.domain.repositories.RecipeAnalysisRepository
import com.example.domain.repositories.pojo.RecipeAnalysisPojo
import io.reactivex.rxjava3.core.Observable

class RecipeAnalysisRepositoryImpl(
    private val apiService: NutritionAnalysisApiService,
    private val mapper: FoodAnalysisMapper
): RecipeAnalysisRepository {

    override fun getRecipeAnalysisData(id: String, key: String, recipeAnalysisPojo: RecipeAnalysisPojo): Observable<FoodAnalysis> {
       return apiService.getRecipeAnalysis(id, key, recipeAnalysisPojo)
            .map { mapper.mapToFoodAnalysis(it) }
    }
}