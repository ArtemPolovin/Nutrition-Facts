package com.example.domain.usecases.foodTextAnalysis

import com.example.domain.models.FoodAnalysis
import io.reactivex.rxjava3.core.Single

interface FetchFoodAnalysisUseCase{
    fun fetchFoodAnalysisData(id: String, key: String, ingredient: String): Single<FoodAnalysis>
}