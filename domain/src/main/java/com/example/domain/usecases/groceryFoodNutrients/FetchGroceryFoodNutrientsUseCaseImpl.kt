package com.example.domain.usecases.groceryFoodNutrients

import com.example.domain.models.GroceryFoodNutrients
import com.example.domain.repositories.GroceryFoodNutrientsRepository
import com.example.domain.repositories.pojo.GroceryFoodPojo
import io.reactivex.rxjava3.core.Single

class FetchGroceryFoodNutrientsUseCaseImpl (private val groceryFoodNutrientsRepo: GroceryFoodNutrientsRepository): FetchGroceryFoodNutrientsUseCase {
    override fun fetchGroceryFoodNutrients(
        id: String,
        key: String,
        groceryFoodNutrientsPojoList: GroceryFoodPojo
    ): Single<GroceryFoodNutrients> {
       return groceryFoodNutrientsRepo.getGroceryFoodNutrients(id,key,groceryFoodNutrientsPojoList)
    }
}