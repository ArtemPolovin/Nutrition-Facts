package com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository

import com.example.nutritionfacts.data.repository.pojo.GroceryFoodPojo
import com.example.nutritionfacts.ui.models.GroceryFoodNutrients
import io.reactivex.rxjava3.core.Single

interface GroceryFoodNutrientsRepository {
    fun getGroceryFoodNutrients(
        id: String,
        key: String,
        groceryFoodNutrientsPojoList: GroceryFoodPojo
    ): Single<GroceryFoodNutrients>
}
