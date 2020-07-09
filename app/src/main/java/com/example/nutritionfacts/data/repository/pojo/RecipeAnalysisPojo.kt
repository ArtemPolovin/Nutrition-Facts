package com.example.nutritionfacts.data.repository.pojo

import com.google.gson.annotations.SerializedName

class RecipeAnalysisPojo (
    @SerializedName("ingr")
    val ingredients: List<String>)