package com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository

import com.example.nutritionfacts.ui.groceryFoodNutrients.GroceryFoodNutrientsFragment
import dagger.Component

@Component(modules = [GroceryFoodNutrientsModule::class])
interface GroceryFoodNutrientsComponent {

    fun injectGroceryFoodNutrientsFragment(groceryFoodNutrientsFragment: GroceryFoodNutrientsFragment)
}