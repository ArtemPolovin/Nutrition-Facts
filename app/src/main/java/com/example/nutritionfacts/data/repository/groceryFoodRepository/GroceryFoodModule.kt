package com.example.nutritionfacts.data.repository.groceryFoodRepository

import androidx.annotation.NonNull
import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.GroceryFoodMapper
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class GroceryFoodModule {

    @Provides
    @Singleton
    fun providerGroceryFoodRepository(
        mapper: GroceryFoodMapper,
        apiService: NutritionAnalysisApiService
    ): GroceryFoodRepository = GroceryFoodRepositoryImpl(apiService, mapper)

    @Provides
    fun providerMapper() = GroceryFoodMapper()

    @Provides
    @Singleton
    fun providerApiService() = NutritionAnalysisApiService()
}