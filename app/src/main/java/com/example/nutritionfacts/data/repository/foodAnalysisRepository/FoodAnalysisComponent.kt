package com.example.nutritionfacts.data.repository.foodAnalysisRepository

import com.example.nutritionfacts.ui.foodTextAnalysis.FoodAnalysisFragment
import com.example.nutritionfacts.ui.viewStates.WelcomeScreenViewState
import com.example.nutritionfacts.ui.welcomeScreen.WelcomeScreen
import dagger.Component

@Component(modules = [FoodAnalysisModule::class])
interface FoodAnalysisComponent {

    fun injectFoodAnalysisFragment(foodAnalysisFragment: FoodAnalysisFragment)
}