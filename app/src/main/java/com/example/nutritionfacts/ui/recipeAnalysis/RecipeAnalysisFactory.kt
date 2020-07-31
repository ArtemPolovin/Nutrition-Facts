package com.example.nutritionfacts.ui.recipeAnalysis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.repositories.RecipeAnalysisRepository
import com.example.domain.repositories.TranslateRepository
import com.example.domain.usecases.recipeAnalysis.FetchRecipeAnalysisUseCase
import com.example.domain.usecases.translateRequestText.TranslateTextUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class RecipeAnalysisFactory @Inject constructor(
    private val fetchRecipeAnalysisUseCase: FetchRecipeAnalysisUseCase,
    private val translateTextUseCase: TranslateTextUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         if (modelClass.isAssignableFrom(RecipeAnalysisViewModel::class.java)) {
            return RecipeAnalysisViewModel(fetchRecipeAnalysisUseCase,translateTextUseCase) as T
        }
        throw  IllegalArgumentException("ViewModel was not found")
    }
}