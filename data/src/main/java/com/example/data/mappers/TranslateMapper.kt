package com.example.data.mappers

import com.example.data.modulsApi.translateResponse.TranslateApi

class TranslateMapper {
    fun mapToList(translateApi: TranslateApi): String {
        return translateApi.text[0]
    }
}