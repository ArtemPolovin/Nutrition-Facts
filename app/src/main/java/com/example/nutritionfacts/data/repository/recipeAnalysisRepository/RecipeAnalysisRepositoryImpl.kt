package com.example.nutritionfacts.data.repository.recipeAnalysisRepository

import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.data.repository.pojo.RecipeAnalysisPojo
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import com.example.nutritionfacts.ui.models.FoodAnalysis
import io.reactivex.rxjava3.core.Single

class RecipeAnalysisRepositoryImpl(
    private val apiService: NutritionAnalysisApiService,
    private val mapper: FoodAnalysisMapper
): RecipeAnalysisRepository {

    override fun getRecipeAnalysisData(recipeAnalysisPojo: RecipeAnalysisPojo): Single<FoodAnalysis> {
       return apiService.getRecipeAnalysis(recipeAnalysisPojo)
            .map { mapper.mapToFoodAnalysis(it) }
    }
}