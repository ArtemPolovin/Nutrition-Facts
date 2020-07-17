package com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository

import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import com.example.nutritionfacts.mapp.GroceryFoodNutrientsMapper
import dagger.Module
import dagger.Provides

@Module
class GroceryFoodNutrientsModule {

    @Provides
    fun providerGroceryFoodNutrientsRepository(
        mapper: GroceryFoodNutrientsMapper,
        serviceApi: NutritionAnalysisApiService
    ): GroceryFoodNutrientsRepository = GroceryFoodNutrientsRepositoryImpl(serviceApi, mapper)

    @Provides
    fun providerMapper() = GroceryFoodNutrientsMapper()

    @Provides
    fun providerApiService() =  NutritionAnalysisApiService()
}