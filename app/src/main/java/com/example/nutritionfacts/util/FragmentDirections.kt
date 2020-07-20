package com.example.nutritionfacts.util

import androidx.navigation.NavDestination
import com.example.nutritionfacts.R
import com.example.nutritionfacts.ui.foodTextAnalysis.FoodAnalysisFragment
import com.example.nutritionfacts.ui.recipeAnalysis.RecipeAnalysisFragment

fun actionToFoodTextAnalysisFragment(navDestination: NavDestination?): Int {
    return when (navDestination?.id) {
        R.id.nav_recipe_analysis -> R.id.action_nav_recipe_analysis_to_nav_food_text_analysis2
        R.id.nav_grocery_food_analysis -> R.id.action_foodDatabaseFragment_to_nav_food_text_analysis
        else -> R.id.nav_food_text_analysis
    }
}

fun actionToRecipeAnalysisFragment(navDestination: NavDestination?): Int {
    return when (navDestination?.id) {
        R.id.nav_food_text_analysis -> R.id.action_nav_food_text_analysis_to_nav_recipe_analysis
        R.id.nav_grocery_food_analysis -> R.id.action_foodDatabaseFragment_to_nav_recipe_analysis
        else -> R.id.nav_recipe_analysis
    }
}

fun actionToGroceryFodAnalysisFragment(navDestination: NavDestination?): Int {
    return when (navDestination?.id) {
        R.id.nav_food_text_analysis -> R.id.action_nav_food_text_analysis_to_foodDatabaseFragment
        R.id.nav_recipe_analysis -> R.id.action_nav_recipe_analysis_to_foodDatabaseFragment
        else -> R.id.nav_grocery_food_analysis
    }
}