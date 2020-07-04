package com.example.nutritionfacts.data.repository.foodAnalysisRepository

import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import dagger.Module
import dagger.Provides

@Module
class FoodAnalysisModule {

    @Provides
    fun provideFoodAnalysisMapper() = FoodAnalysisMapper()

    @Provides
    fun provideNutritionAnalysisApiService() = NutritionAnalysisApiService()

    @Provides
    fun provideFoodAnalysisRepository(
        mapper: FoodAnalysisMapper,
        apiService: NutritionAnalysisApiService
    ): FoodAnalysisRepository = FoodAnalysisRepositoryIml(apiService, mapper)

}