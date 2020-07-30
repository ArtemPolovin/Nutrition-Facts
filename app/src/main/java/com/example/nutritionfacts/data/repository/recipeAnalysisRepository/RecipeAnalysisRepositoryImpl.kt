package com.example.nutritionfacts.data.repository.recipeAnalysisRepository

import android.util.Log
import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.data.repository.pojo.RecipeAnalysisPojo
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import com.example.nutritionfacts.ui.models.FoodAnalysis
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class RecipeAnalysisRepositoryImpl(
    private val apiService: NutritionAnalysisApiService,
    private val mapper: FoodAnalysisMapper
): RecipeAnalysisRepository {

    override fun getRecipeAnalysisData(id: String, key: String, recipeAnalysisPojo: RecipeAnalysisPojo): Observable<FoodAnalysis> {
       return apiService.getRecipeAnalysis(id, key, recipeAnalysisPojo)
            .map { mapper.mapToFoodAnalysis(it) }
    }
}