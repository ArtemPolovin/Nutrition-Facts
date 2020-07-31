package com.example.domain.usecases.recipeAnalysis

import com.example.domain.models.FoodAnalysis
import com.example.domain.repositories.RecipeAnalysisRepository
import com.example.domain.repositories.pojo.RecipeAnalysisPojo
import io.reactivex.rxjava3.core.Observable

class FetchRecipeAnalysisUseCaseImpl(private val recipeAnalysisRepo: RecipeAnalysisRepository): FetchRecipeAnalysisUseCase {
    override fun fetchRecipeAnalysis(
        id: String,
        key: String,
        recipeAnalysisPojo: RecipeAnalysisPojo
    ): Observable<FoodAnalysis> {
       return recipeAnalysisRepo.getRecipeAnalysisData(id,key,recipeAnalysisPojo)
    }
}