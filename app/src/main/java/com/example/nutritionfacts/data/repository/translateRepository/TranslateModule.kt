package com.example.nutritionfacts.data.repository.translateRepository

import androidx.annotation.NonNull
import com.example.nutritionfacts.data.network.TranslateApiService
import com.example.nutritionfacts.mapp.TranslateMapper
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class TranslateModule {

    @Provides
    @Singleton
    fun providerTranslateRepository(
        mapper: TranslateMapper,
        translateApiService: TranslateApiService
    ): TranslateRepository = TranslateRepositoryImpl(mapper, translateApiService)

    @Provides
    @Singleton
    fun providerTranslateApiService() = TranslateApiService()

    @Provides
    fun providerTranslateMapper() = TranslateMapper()
}