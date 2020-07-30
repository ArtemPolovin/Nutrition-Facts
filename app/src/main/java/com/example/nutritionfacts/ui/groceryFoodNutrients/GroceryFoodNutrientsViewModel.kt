package com.example.nutritionfacts.ui.groceryFoodNutrients

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nutritionfacts.App
import com.example.nutritionfacts.data.provider.LanguageProvider
import com.example.nutritionfacts.data.provider.LanguageProviderImpl
import com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository.GroceryFoodNutrientsRepository
import com.example.nutritionfacts.data.repository.pojo.GroceryFoodPojo
import com.example.nutritionfacts.data.repository.translateRepository.TranslateRepository
import com.example.nutritionfacts.ui.viewStates.FoodAnalysisViewState
import com.example.nutritionfacts.ui.viewStates.GroceryFoodNutrientsViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class GroceryFoodNutrientsViewModel(
  private val  groceryFoodNutrientsRepository: GroceryFoodNutrientsRepository
) : ViewModel() {

    private val id = "92ae2871"
    private val key = "167c9bb5ea6b17f70c5d33318c9f1fa0"

    private var disposable: Disposable? = null

    private val _groceryFoodNutrients = MutableLiveData<GroceryFoodNutrientsViewState>()
    val groceryFoodNutrients: LiveData<GroceryFoodNutrientsViewState> get() = _groceryFoodNutrients

    private fun fetchGroceryFoodNutrients(groceryFoodPojo: GroceryFoodPojo) {

        disposable?.dispose()
        _groceryFoodNutrients.value = GroceryFoodNutrientsViewState.Loading

        disposable =
            groceryFoodNutrientsRepository.getGroceryFoodNutrients(id, key, groceryFoodPojo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _groceryFoodNutrients.value = GroceryFoodNutrientsViewState.GroceryFoodLoaded(it)
                },
                    {
                        _groceryFoodNutrients.value = GroceryFoodNutrientsViewState.Error
                        Log.i("ERROR", "${it.printStackTrace()}")
                    }
                )
    }

    fun getGroceryFoodPojo(groceryFoodPojo: GroceryFoodPojo) {
        fetchGroceryFoodNutrients(groceryFoodPojo)
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}