package com.example.nutritionfacts.data.repository.foodAnalysisResponse

data class FoodAnalysisApi(
    val calories: Int,
    val cautions: List<String>,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalNutrientsKCal: TotalNutrientsKCal,
    val totalWeight: Double,
    val uri: String
)