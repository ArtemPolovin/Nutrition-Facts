package com.example.nutritionfacts.data.repository.groceryFoodRepository

import com.example.nutritionfacts.data.repository.translateRepository.TranslateModule
import com.example.nutritionfacts.ui.groceryFoodAnalysis.GroceryFoodAnalysisFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GroceryFoodModule::class, TranslateModule::class])
interface GroceryFoodComponent {

    fun injectGroceryFoodFragment(groceryFoodAnalysisFragment: GroceryFoodAnalysisFragment)
}