package com.example.domain.repositories

import io.reactivex.rxjava3.core.Single

interface TranslateRepository {
    fun translate(text: String, language: String): Single<String>
}