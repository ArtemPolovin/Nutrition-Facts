package com.example.domain.usecases.translateRequestText

import com.example.domain.repositories.TranslateRepository
import io.reactivex.rxjava3.core.Single

class TranslateTextUseCaseImpl(private val translateRepo: TranslateRepository): TranslateTextUseCase {
    override fun translateText(text: String, language: String): Single<String> {
       return translateRepo.translate(text,language)
    }
}