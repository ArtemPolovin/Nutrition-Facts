package com.example.nutritionfacts.di

import com.example.data.network.retrofit.NutritionAnalysisApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NutritionAnalysisApiServiceModule {
    @Provides
    @Singleton
    fun provideNutritionAnalysisApiService() =
        NutritionAnalysisApiService()
}