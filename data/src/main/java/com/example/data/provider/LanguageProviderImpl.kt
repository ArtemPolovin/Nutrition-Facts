package com.example.data.provider

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.data.internal.LanguageSystem

const val LANGUAGE_SYSTEM = "LANGUAGE"

class LanguageProviderImpl (context: Context):
    LanguageProvider {
    private val appContext = context.applicationContext

    private val preferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    override fun getLanguageProvider(): LanguageSystem {
       val selectedLanguage: String? =   preferences.getString(LANGUAGE_SYSTEM, LanguageSystem.ENGLISH.value)
        return LanguageSystem.valueOf(selectedLanguage ?: "")
    }

}