package com.example.data.di

import com.example.data.mappers.FoodAnalysisMapper
import dagger.Module
import dagger.Provides

@Module
class FoodAnalysisMapperModule {
    @Provides
    fun provideFoodAnalysisMapper() = FoodAnalysisMapper()
}