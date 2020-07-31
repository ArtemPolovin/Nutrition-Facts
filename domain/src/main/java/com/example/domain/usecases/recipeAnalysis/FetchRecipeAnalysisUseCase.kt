package com.example.domain.usecases.recipeAnalysis

import com.example.domain.models.FoodAnalysis
import com.example.domain.repositories.pojo.RecipeAnalysisPojo
import io.reactivex.rxjava3.core.Observable

interface FetchRecipeAnalysisUseCase {
    fun fetchRecipeAnalysis(id: String, key: String, recipeAnalysisPojo: RecipeAnalysisPojo): Observable<FoodAnalysis>
}