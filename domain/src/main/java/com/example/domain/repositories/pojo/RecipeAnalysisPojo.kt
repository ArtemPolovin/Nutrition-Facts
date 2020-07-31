package com.example.domain.repositories.pojo

import com.google.gson.annotations.SerializedName

class RecipeAnalysisPojo (
    @SerializedName("ingr")
    val ingredients: List<String>)