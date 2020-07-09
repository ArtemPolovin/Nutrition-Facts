package com.example.nutritionfacts.data.repository.recipeAnalysisRepository

import com.example.nutritionfacts.data.repository.pojo.RecipeAnalysisPojo
import com.example.nutritionfacts.ui.models.FoodAnalysis
import io.reactivex.rxjava3.core.Single

interface RecipeAnalysisRepository {
    fun getRecipeAnalysisData(recipeAnalysisPojo: RecipeAnalysisPojo): Single<FoodAnalysis>
}