package com.example.data.di

import com.example.data.implementationRepo.GroceryFoodNutrientsRepositoryImpl
import com.example.data.mappers.GroceryFoodNutrientsMapper
import com.example.data.network.retrofit.NutritionAnalysisApiService
import com.example.domain.repositories.GroceryFoodNutrientsRepository
import com.example.domain.usecases.groceryFoodNutrients.FetchGroceryFoodNutrientsUseCase
import com.example.domain.usecases.groceryFoodNutrients.FetchGroceryFoodNutrientsUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GroceryFoodNutrientsModule {

    @Provides
    @Singleton
    fun provideFetchGroceryFoodNutrientsUseCase(groceryFoodNutrientsRepo: GroceryFoodNutrientsRepository):FetchGroceryFoodNutrientsUseCase =
        FetchGroceryFoodNutrientsUseCaseImpl(groceryFoodNutrientsRepo)

    @Provides
    @Singleton
    fun providerGroceryFoodNutrientsRepository(
        mapper: GroceryFoodNutrientsMapper,
        serviceApi: NutritionAnalysisApiService
    ): GroceryFoodNutrientsRepository =
        GroceryFoodNutrientsRepositoryImpl(
            serviceApi,
            mapper
        )

    @Provides
    fun provideGroceryFoodNutrientsMapper() = GroceryFoodNutrientsMapper()
}