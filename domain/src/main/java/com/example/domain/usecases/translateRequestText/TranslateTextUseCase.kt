package com.example.domain.usecases.translateRequestText

import io.reactivex.rxjava3.core.Single

interface TranslateTextUseCase {
    fun translateText(text: String, language: String): Single<String>
}