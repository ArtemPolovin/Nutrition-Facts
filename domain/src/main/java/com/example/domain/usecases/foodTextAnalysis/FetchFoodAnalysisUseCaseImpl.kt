package com.example.domain.usecases.foodTextAnalysis

import com.example.domain.models.FoodAnalysis
import com.example.domain.repositories.FoodAnalysisRepository
import io.reactivex.rxjava3.core.Single

class FetchFoodAnalysisUseCaseImpl(private val foodAnalysisRepo: FoodAnalysisRepository) :
    FetchFoodAnalysisUseCase {
    override fun fetchFoodAnalysisData(
        id: String,
        key: String,
        ingredient: String
    ): Single<FoodAnalysis> {
        return foodAnalysisRepo.getFoodAnalysisData(id, key, ingredient)
    }

}