package com.example.nutritionfacts.di

import com.example.data.mappers.FoodAnalysisMapper
import dagger.Module
import dagger.Provides

@Module
class FoodAnalysisMapperModule {
    @Provides
    fun provideFoodAnalysisMapper() = FoodAnalysisMapper()
}