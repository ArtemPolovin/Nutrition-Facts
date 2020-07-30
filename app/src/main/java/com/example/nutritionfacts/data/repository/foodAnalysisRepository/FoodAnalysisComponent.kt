package com.example.nutritionfacts.data.repository.foodAnalysisRepository

import com.example.nutritionfacts.data.repository.translateRepository.TranslateModule
import com.example.nutritionfacts.ui.foodTextAnalysis.FoodAnalysisFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FoodAnalysisModule::class, TranslateModule::class])
interface FoodAnalysisComponent {

    fun injectFoodAnalysisFragment(foodAnalysisFragment: FoodAnalysisFragment)
}