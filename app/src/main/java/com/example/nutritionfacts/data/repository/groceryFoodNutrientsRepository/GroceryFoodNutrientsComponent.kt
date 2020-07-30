package com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository

import com.example.nutritionfacts.data.repository.translateRepository.TranslateModule
import com.example.nutritionfacts.ui.groceryFoodNutrients.GroceryFoodNutrientsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GroceryFoodNutrientsModule::class, TranslateModule::class])
interface GroceryFoodNutrientsComponent {

    fun injectGroceryFoodNutrientsFragment(groceryFoodNutrientsFragment: GroceryFoodNutrientsFragment)
}