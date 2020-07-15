package com.example.nutritionfacts.data.repository.groceryFoodRepository

import com.example.nutritionfacts.ui.groceryFoodAnalysis.GroceryFoodAnalysisFragment
import dagger.Component

@Component(modules = [GroceryFoodModule::class])
interface GroceryFoodComponent {

    fun injectGroceryFoodFragment(groceryFoodAnalysisFragment: GroceryFoodAnalysisFragment)
}