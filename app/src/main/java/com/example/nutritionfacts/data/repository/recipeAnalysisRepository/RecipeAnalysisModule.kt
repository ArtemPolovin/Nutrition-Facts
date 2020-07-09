package com.example.nutritionfacts.data.repository.recipeAnalysisRepository

import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import dagger.Module
import dagger.Provides


@Module
class RecipeAnalysisModule {

    @Provides
    fun providerRecipeAnalysisRepository(
        apiService: NutritionAnalysisApiService,
        mapper: FoodAnalysisMapper
    ): RecipeAnalysisRepository = RecipeAnalysisRepositoryImpl(apiService, mapper)

    @Provides
    fun providerApiService() = NutritionAnalysisApiService()

    @Provides
    fun providerMapper() = FoodAnalysisMapper()
}