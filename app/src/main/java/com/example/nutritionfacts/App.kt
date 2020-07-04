package com.example.nutritionfacts

import android.app.Application
import com.example.nutritionfacts.data.repository.foodAnalysisRepository.DaggerFoodAnalysisComponent
import com.example.nutritionfacts.data.repository.foodAnalysisRepository.FoodAnalysisComponent

class App : Application() {

    lateinit var foodAnalysisAppComponent: FoodAnalysisComponent

    override fun onCreate() {
        super.onCreate()
        foodAnalysisAppComponent = DaggerFoodAnalysisComponent.create()
    }
}