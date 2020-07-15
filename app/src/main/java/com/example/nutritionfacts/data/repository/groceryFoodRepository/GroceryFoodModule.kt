package com.example.nutritionfacts.data.repository.groceryFoodRepository

import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.GroceryFoodMapper
import dagger.Module
import dagger.Provides

@Module
class GroceryFoodModule {

    @Provides
    fun providerGroceryFoodRepository(
        mapper: GroceryFoodMapper,
        apiService: NutritionAnalysisApiService
    ): GroceryFoodRepository = GroceryFoodRepositoryImpl(apiService, mapper)

    @Provides
    fun providerMapper() = GroceryFoodMapper()

    @Provides
    fun providerApiService() = NutritionAnalysisApiService()
}