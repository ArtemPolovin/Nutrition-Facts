package com.example.nutritionfacts.data.repository.translateRepository

import android.util.Log
import com.example.nutritionfacts.data.network.TranslateApiService
import com.example.nutritionfacts.mapp.TranslateMapper
import io.reactivex.rxjava3.core.Single

class TranslateRepositoryImpl (
    private val mapper : TranslateMapper,
    private val translateApiService : TranslateApiService
): TranslateRepository {

    override fun translate(text: String, language: String): Single<String> {
       return translateApiService.translate(text,language).map { mapper.mapToList(it) }
    }
}