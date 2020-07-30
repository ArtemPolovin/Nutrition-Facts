package com.example.nutritionfacts.data.repository.groceryFoodNutrientsRepository

import androidx.annotation.NonNull
import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import com.example.nutritionfacts.mapp.GroceryFoodNutrientsMapper
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class GroceryFoodNutrientsModule {

    @Provides
    @Singleton
    fun providerGroceryFoodNutrientsRepository(
        mapper: GroceryFoodNutrientsMapper,
        serviceApi: NutritionAnalysisApiService
    ): GroceryFoodNutrientsRepository = GroceryFoodNutrientsRepositoryImpl(serviceApi, mapper)

    @Provides
    fun providerMapper() = GroceryFoodNutrientsMapper()

    @Provides
    @Singleton
    fun providerApiService() =  NutritionAnalysisApiService()
}