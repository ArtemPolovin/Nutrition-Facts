package com.example.nutritionfacts.data.repository.recipeAnalysisRepository

import androidx.annotation.NonNull
import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton


@Module
class RecipeAnalysisModule {

    @Provides
    @Singleton
    fun providerRecipeAnalysisRepository(
        apiService: NutritionAnalysisApiService,
        mapper: FoodAnalysisMapper
    ): RecipeAnalysisRepository = RecipeAnalysisRepositoryImpl(apiService, mapper)

    @Provides
    @Singleton
    fun providerApiService() = NutritionAnalysisApiService()

    @Provides
    fun providerMapper() = FoodAnalysisMapper()
}