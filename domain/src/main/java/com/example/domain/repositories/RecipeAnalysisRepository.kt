package com.example.domain.repositories

import com.example.domain.models.FoodAnalysis
import com.example.domain.repositories.pojo.RecipeAnalysisPojo
import io.reactivex.rxjava3.core.Observable

interface RecipeAnalysisRepository {
    fun getRecipeAnalysisData(id: String, key: String, recipeAnalysisPojo: RecipeAnalysisPojo): Observable<FoodAnalysis>
}