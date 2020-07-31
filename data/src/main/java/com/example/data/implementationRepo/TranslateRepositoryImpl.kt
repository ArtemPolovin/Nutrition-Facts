package com.example.data.implementationRepo

import com.example.data.network.retrofit.TranslateApiService
import com.example.data.mappers.TranslateMapper
import com.example.domain.repositories.TranslateRepository
import io.reactivex.rxjava3.core.Single

class TranslateRepositoryImpl (
    private val mapper : TranslateMapper,
    private val translateApiService : TranslateApiService
): TranslateRepository {

    override fun translate(text: String, language: String): Single<String> {
       return translateApiService.translate(text,language).map { mapper.mapToList(it) }
    }
}