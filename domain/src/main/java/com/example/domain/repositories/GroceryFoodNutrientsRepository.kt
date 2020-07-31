package com.example.domain.repositories

import com.example.domain.models.GroceryFoodNutrients
import com.example.domain.repositories.pojo.GroceryFoodPojo
import io.reactivex.rxjava3.core.Single

interface GroceryFoodNutrientsRepository {
    fun getGroceryFoodNutrients(
        id: String,
        key: String,
        groceryFoodNutrientsPojoList: GroceryFoodPojo
    ): Single<GroceryFoodNutrients>
}
