package com.example.nutritionfacts

import android.app.Application
import com.example.nutritionfacts.data.repository.foodAnalysisRepository.DaggerFoodAnalysisComponent
import com.example.nutritionfacts.data.repository.foodAnalysisRepository.FoodAnalysisComponent
import com.example.nutritionfacts.data.repository.groceryFoodRepository.DaggerGroceryFoodComponent
import com.example.nutritionfacts.data.repository.groceryFoodRepository.GroceryFoodComponent
import com.example.nutritionfacts.data.repository.recipeAnalysisRepository.DaggerRecipeAnalysisComponent
import com.example.nutritionfacts.data.repository.recipeAnalysisRepository.RecipeAnalysisComponent

class App : Application() {

    lateinit var foodAnalysisAppComponent: FoodAnalysisComponent
    lateinit var recipeAnalysisComponent: RecipeAnalysisComponent
    lateinit var groceryFoodAnalysisComponent: GroceryFoodComponent

    override fun onCreate() {
        super.onCreate()
        foodAnalysisAppComponent = DaggerFoodAnalysisComponent.create()
        recipeAnalysisComponent = DaggerRecipeAnalysisComponent.create()
        groceryFoodAnalysisComponent = DaggerGroceryFoodComponent.create()
    }
}