package com.example.domain.repositories

import com.example.domain.models.FoodAnalysis
import io.reactivex.rxjava3.core.Single

interface FoodAnalysisRepository {

    fun getFoodAnalysisData(id: String, key: String, ingredient: String): Single<FoodAnalysis>
}