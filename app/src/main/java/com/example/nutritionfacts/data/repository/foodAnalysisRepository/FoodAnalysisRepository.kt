package com.example.nutritionfacts.data.repository.foodAnalysisRepository

import com.example.nutritionfacts.ui.models.FoodAnalysis
import io.reactivex.rxjava3.core.Single

interface FoodAnalysisRepository {

    fun getFoodAnalysisData(id: String, key: String, ingredient: String): Single<FoodAnalysis>
}