package com.example.nutritionfacts.data.repository.recipeAnalysisRepository

import com.example.nutritionfacts.ui.recipeAnalysis.RecipeAnalysisFragment
import dagger.Component

@Component(modules = [RecipeAnalysisModule::class])
interface RecipeAnalysisComponent {

    fun injectRecipeAnalysisFragment(recipeAnalysisFragment: RecipeAnalysisFragment)

}