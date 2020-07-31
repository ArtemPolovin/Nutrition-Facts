package com.example.domain.models

import java.io.Serializable

class GroceryFood(
    val foodName: String,
    val brandName: String?,
    val image: String?,
    val measureURI: String,
    val foodId: String
) : Serializable