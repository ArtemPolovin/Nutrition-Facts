package com.example.nutritionfacts.data.repository.foodAnalysisRepository

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull
import com.example.nutritionfacts.data.network.NutritionAnalysisApiService
import com.example.nutritionfacts.mapp.FoodAnalysisMapper
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class FoodAnalysisModule {

    @Provides
    fun provideFoodAnalysisMapper() = FoodAnalysisMapper()

    @Provides
    @Singleton
    fun provideNutritionAnalysisApiService() = NutritionAnalysisApiService()

    @Provides
    @Singleton
    fun provideFoodAnalysisRepository(
        mapper: FoodAnalysisMapper,
        apiService: NutritionAnalysisApiService
    ): FoodAnalysisRepository = FoodAnalysisRepositoryIml(apiService, mapper)

}