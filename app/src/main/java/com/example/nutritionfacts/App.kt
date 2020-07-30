package com.example.nutritionfacts

import android.app.Application
import android.content.Context
import com.example.nutritionfacts.data.repository.foodAnalysisRepository.DaggerFoodAnalysisComponent
import com.example.nutritionfacts.data.repository.foodAnalysisRepository.FoodAnalysisComponent
import com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository.DaggerGroceryFoodNutrientsComponent
import com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository.GroceryFoodNutrientsComponent
import com.example.nutritionfacts.data.repository.groceryFoodRepository.DaggerGroceryFoodComponent
import com.example.nutritionfacts.data.repository.groceryFoodRepository.GroceryFoodComponent
import com.example.nutritionfacts.data.repository.recipeAnalysisRepository.DaggerRecipeAnalysisComponent
import com.example.nutritionfacts.data.repository.recipeAnalysisRepository.RecipeAnalysisComponent

class App : Application() {

    lateinit var foodAnalysisAppComponent: FoodAnalysisComponent
    lateinit var recipeAnalysisComponent: RecipeAnalysisComponent
    lateinit var groceryFoodAnalysisComponent: GroceryFoodComponent
    lateinit var groceryFoodNutrientsComponent: GroceryFoodNutrientsComponent
    companion object{
      lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        foodAnalysisAppComponent = DaggerFoodAnalysisComponent.create()
        recipeAnalysisComponent = DaggerRecipeAnalysisComponent.create()
        groceryFoodAnalysisComponent = DaggerGroceryFoodComponent.create()
        groceryFoodNutrientsComponent = DaggerGroceryFoodNutrientsComponent.create()
        context = this
    }

}