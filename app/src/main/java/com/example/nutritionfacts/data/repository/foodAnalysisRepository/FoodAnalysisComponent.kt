package com.example.nutritionfacts.data.repository.foodAnalysisRepository

import com.example.nutritionfacts.ui.foodTextAnalysis.FoodAnalysisFragment
import dagger.Component

@Component(modules = [FoodAnalysisModule::class])
interface FoodAnalysisComponent {

    fun injectFoodAnalysisFragment(foodAnalysisFragment: FoodAnalysisFragment)
}