package com.example.nutritionfacts.ui.recipeAnalysis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionfacts.data.repository.recipeAnalysisRepository.RecipeAnalysisRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class RecipeAnalysisFactory @Inject constructor(
    private val recipeAnalysisRepository: RecipeAnalysisRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         if (modelClass.isAssignableFrom(RecipeAnalysisViewModel::class.java)) {
            return RecipeAnalysisViewModel(recipeAnalysisRepository) as T
        }
        throw  IllegalArgumentException("ViewModel was not found")
    }
}