package com.example.nutritionfacts.di

import com.example.data.implementationRepo.GroceryFoodRepositoryImpl
import com.example.data.mappers.GroceryFoodMapper
import com.example.data.network.retrofit.NutritionAnalysisApiService
import com.example.domain.repositories.GroceryFoodRepository
import com.example.domain.usecases.groceryFoodAnalysis.FetchGroceryFoodAnalysisUseCase
import com.example.domain.usecases.groceryFoodAnalysis.FetchGroceryFoodAnalysisUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GroceryFoodAnalysisModule {

    @Provides
    @Singleton
    fun fetchGroceryFoodAnalysisUseCase(groceryFoodAnalysisRepo: GroceryFoodRepository):FetchGroceryFoodAnalysisUseCase =
        FetchGroceryFoodAnalysisUseCaseImpl(groceryFoodAnalysisRepo)

    @Provides
    @Singleton
    fun providerGroceryFoodRepository(
        mapper: GroceryFoodMapper,
        apiService: NutritionAnalysisApiService
    ): GroceryFoodRepository =
        GroceryFoodRepositoryImpl(
            apiService,
            mapper
        )

    @Provides
    fun provideGroceryFoodMapper() = GroceryFoodMapper()
}