package com.example.nutritionfacts.mapp

import com.example.nutritionfacts.data.repository.response.foodAnalysisResponse.FoodAnalysisApi
import com.example.nutritionfacts.ui.models.GroceryFoodNutrients
import java.text.DecimalFormat

class GroceryFoodNutrientsMapper {

    fun mapToNutrientsAnalysis(foodAnalysisApi: FoodAnalysisApi): GroceryFoodNutrients {
        val dFormatter = DecimalFormat("0.0")
        return GroceryFoodNutrients(
            foodAnalysisApi.calories.toString(),
            dFormatter.format(foodAnalysisApi.totalWeight),
            dFormatter.format(foodAnalysisApi.totalNutrients.FAT.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.FASAT.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.PROCNT.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.NA.quantity),

            foodAnalysisApi.totalDaily.FAT.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.FASAT.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.PROCNT.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.NA.quantity.toInt().toString()
        )

    }
}