package com.example.nutritionfacts.di

import com.example.nutritionfacts.ui.foodTextAnalysis.FoodAnalysisFragment
import com.example.nutritionfacts.ui.groceryFoodAnalysis.GroceryFoodAnalysisFragment
import com.example.nutritionfacts.ui.groceryFoodNutrients.GroceryFoodNutrientsFragment
import com.example.nutritionfacts.ui.recipeAnalysis.RecipeAnalysisFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [TranslateModule::class, FoodAnalysisMapperModule::class, FoodAnalysisModule::class,
        GroceryFoodAnalysisModule::class, GroceryFoodNutrientsModule::class,
        NutritionAnalysisApiServiceModule::class, RecipeAnalysisModule::class]
)
interface AppComponent {
    fun inject(foodAnalysisFragment: FoodAnalysisFragment)
    fun inject(groceryFoodNutrientsFragment: GroceryFoodNutrientsFragment)
    fun inject(groceryFoodAnalysisFragment: GroceryFoodAnalysisFragment)
    fun inject(recipeAnalysisFragment: RecipeAnalysisFragment)
}
