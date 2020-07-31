package com.example.data.provider

import com.example.data.internal.LanguageSystem

interface LanguageProvider {
    fun getLanguageProvider(): LanguageSystem
}