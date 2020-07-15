package com.example.nutritionfacts.mapp

import com.example.nutritionfacts.data.repository.response.foodAnalysisResponse.FoodAnalysisApi
import com.example.nutritionfacts.ui.models.FoodAnalysis
import java.text.DecimalFormat

class FoodAnalysisMapper {

    fun mapToFoodAnalysis(foodAnalysisApi: FoodAnalysisApi): FoodAnalysis {
        val dFormatter = DecimalFormat("0.0")

        return FoodAnalysis(
            foodAnalysisApi.calories.toString(),
            dFormatter.format(foodAnalysisApi.totalNutrients.FAT.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.FASAT.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.CHOLE.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.NA.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.CHOCDF.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.FIBTG.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.SUGAR.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.PROCNT.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.PROCNT.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.VITA_RAE.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.VITC.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.THIA.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.RIBF.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.NIA.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.VITB6A.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.VITB12.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.TOCPHA.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.VITK1.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.CA.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.FE.quantity),
            dFormatter.format(foodAnalysisApi.totalNutrients.K.quantity),

            foodAnalysisApi.totalDaily.FAT.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.FASAT.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.CHOLE.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.NA.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.CHOCDF.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.FIBTG.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.PROCNT.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.VITD.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.VITA_RAE.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.VITC.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.THIA.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.RIBF.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.NIA.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.VITB6A.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.VITB12.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.TOCPHA.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.VITK1.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.CA.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.FE.quantity.toInt().toString(),
            foodAnalysisApi.totalDaily.K.quantity.toInt().toString(),
            dFormatter.format(foodAnalysisApi.totalWeight)
        )
    }
}