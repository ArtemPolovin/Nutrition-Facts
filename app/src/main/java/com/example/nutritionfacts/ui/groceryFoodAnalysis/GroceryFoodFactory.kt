package com.example.nutritionfacts.ui.groceryFoodAnalysis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.repositories.GroceryFoodRepository
import com.example.domain.repositories.TranslateRepository
import com.example.domain.usecases.groceryFoodAnalysis.FetchGroceryFoodAnalysisUseCase
import com.example.domain.usecases.translateRequestText.TranslateTextUseCase
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class GroceryFoodFactory @Inject constructor(
    private val fetchGroceryFoodDataUseCase: FetchGroceryFoodAnalysisUseCase,
    private val translateTextUseCase: TranslateTextUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GroceryFoodAnalysisViewModel::class.java)) {
            return GroceryFoodAnalysisViewModel(fetchGroceryFoodDataUseCase, translateTextUseCase) as T
        }
        throw IllegalArgumentException("ViewModel was not found")
    }
}