package com.example.nutritionfacts.di

import com.example.data.implementationRepo.FoodAnalysisRepositoryIml
import com.example.data.mappers.FoodAnalysisMapper
import com.example.data.network.retrofit.NutritionAnalysisApiService
import com.example.domain.repositories.FoodAnalysisRepository
import com.example.domain.usecases.foodTextAnalysis.FetchFoodAnalysisUseCase
import com.example.domain.usecases.foodTextAnalysis.FetchFoodAnalysisUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FoodAnalysisModule {

    @Provides
    @Singleton
    fun provideFetchFoodAnalysisUseCase(foodAnalysisRepository: FoodAnalysisRepository):FetchFoodAnalysisUseCase =
        FetchFoodAnalysisUseCaseImpl(foodAnalysisRepository)

    @Provides
    @Singleton
    fun provideFoodAnalysisRepository(
        mapper: FoodAnalysisMapper,
        apiService: NutritionAnalysisApiService
    ): FoodAnalysisRepository =
        FoodAnalysisRepositoryIml(
            apiService,
            mapper
        )




}