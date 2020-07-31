package com.example.domain.usecases.groceryFoodNutrients

import com.example.domain.models.GroceryFoodNutrients
import com.example.domain.repositories.pojo.GroceryFoodPojo
import io.reactivex.rxjava3.core.Single

interface FetchGroceryFoodNutrientsUseCase {
    fun fetchGroceryFoodNutrients(
        id: String,
        key: String,
        groceryFoodNutrientsPojoList: GroceryFoodPojo
    ): Single<GroceryFoodNutrients>
}