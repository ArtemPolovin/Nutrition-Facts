package com.example.nutritionfacts

import android.app.Application
import android.content.Context
import com.example.nutritionfacts.di.AppComponent
import com.example.nutritionfacts.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    companion object{
      lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        context = this
    }

}