package com.example.nutritionfacts.data.repository.recipeAnalysisRepository

import com.example.nutritionfacts.data.repository.translateRepository.TranslateModule
import com.example.nutritionfacts.ui.recipeAnalysis.RecipeAnalysisFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RecipeAnalysisModule::class, TranslateModule::class])
interface RecipeAnalysisComponent {

    fun injectRecipeAnalysisFragment(recipeAnalysisFragment: RecipeAnalysisFragment)

}