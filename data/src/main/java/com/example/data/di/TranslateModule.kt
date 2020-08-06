package com.example.data.di

import com.example.data.implementationRepo.TranslateRepositoryImpl
import com.example.data.network.retrofit.TranslateApiService
import com.example.data.mappers.TranslateMapper
import com.example.domain.repositories.TranslateRepository
import com.example.domain.usecases.translateRequestText.TranslateTextUseCase
import com.example.domain.usecases.translateRequestText.TranslateTextUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TranslateModule {

    @Provides
    @Singleton
    fun provideTranslateTextUseCase(translateRepo: TranslateRepository): TranslateTextUseCase =
        TranslateTextUseCaseImpl(translateRepo)

        @Provides
        @Singleton
        fun providerTranslateRepository(
            mapper: TranslateMapper,
            translateApiService: TranslateApiService
        ): TranslateRepository =
            TranslateRepositoryImpl(
                mapper,
                translateApiService
            )

    @Provides
    @Singleton
    fun providerTranslateApiService() =
        TranslateApiService()

    @Provides
    fun providerTranslateMapper() = TranslateMapper()
}