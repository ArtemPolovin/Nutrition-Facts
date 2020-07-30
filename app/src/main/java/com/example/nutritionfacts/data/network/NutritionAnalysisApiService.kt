package com.example.nutritionfacts.data.network

import com.example.nutritionfacts.data.repository.pojo.GroceryFoodPojo
import com.example.nutritionfacts.data.repository.pojo.RecipeAnalysisPojo
import com.example.nutritionfacts.data.repository.response.foodAnalysisResponse.FoodAnalysisApi
import com.example.nutritionfacts.data.repository.response.groceryFoodResponse.GroceryFoodApi
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NutritionAnalysisApiService {

    @GET("/api/nutrition-data")
    fun getFoodAnalysis(
        @Query("app_id") id: String,
        @Query("app_key") key: String,
        @Query("ingr") ingredient: String
    ): Single<FoodAnalysisApi>

    @POST("/api/nutrition-details")
    fun getRecipeAnalysis(
        @Query("app_id") id: String,
        @Query("app_key") key: String,
        @Body recipeAnalysisPojo: RecipeAnalysisPojo
    ): Observable<FoodAnalysisApi>

    @GET("/api/food-database/v2/parser")
    fun getGroceryFoodData(
        @Query("app_id") id: String,
        @Query("app_key") key: String,
        @Query("ingr") groceryIngredient: String
    ): Single<GroceryFoodApi>

    @POST("/api/food-database/v2/nutrients")
    fun getGroceryFoodNutrients(
        @Query("app_id") id: String,
        @Query("app_key") key: String,
        @Body ingredients: GroceryFoodPojo
    ): Single<FoodAnalysisApi>

    companion object {
        operator fun invoke(): NutritionAnalysisApiService {
            return Retrofit.Builder()
                .baseUrl("https://api.edamam.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(NutritionAnalysisApiService::class.java)
        }
    }


}