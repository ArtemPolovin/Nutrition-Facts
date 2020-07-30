package com.example.nutritionfacts.data.provider

import com.example.nutritionfacts.data.internal.LanguageSystem

interface LanguageProvider {
    fun getLanguageProvider():LanguageSystem
}