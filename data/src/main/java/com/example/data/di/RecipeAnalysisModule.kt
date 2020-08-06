package com.example.data.di

import com.example.data.implementationRepo.RecipeAnalysisRepositoryImpl
import com.example.data.mappers.FoodAnalysisMapper
import com.example.data.network.retrofit.NutritionAnalysisApiService
import com.example.domain.repositories.RecipeAnalysisRepository
import com.example.domain.usecases.recipeAnalysis.FetchRecipeAnalysisUseCase
import com.example.domain.usecases.recipeAnalysis.FetchRecipeAnalysisUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RecipeAnalysisModule {

    @Provides
    @Singleton
    fun provideFetchRecipeAnalysisUseCase(recipeAnalysisRepo: RecipeAnalysisRepository):FetchRecipeAnalysisUseCase =
        FetchRecipeAnalysisUseCaseImpl(recipeAnalysisRepo)

    @Provides
    @Singleton
    fun providerRecipeAnalysisRepository(
        apiService: NutritionAnalysisApiService,
        mapper: FoodAnalysisMapper
    ): RecipeAnalysisRepository =
        RecipeAnalysisRepositoryImpl(
            apiService,
            mapper
        )
}