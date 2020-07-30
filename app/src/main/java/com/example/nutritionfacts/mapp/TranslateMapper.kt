package com.example.nutritionfacts.mapp

import com.example.nutritionfacts.data.repository.response.translateResponse.TranslateApi
import io.reactivex.rxjava3.core.Single

class TranslateMapper {
    fun mapToList(translateApi: TranslateApi): String {
        return translateApi.text[0]
    }
}