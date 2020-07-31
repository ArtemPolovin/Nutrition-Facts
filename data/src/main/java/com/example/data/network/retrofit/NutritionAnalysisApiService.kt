package com.example.data.network.retrofit

import com.example.data.modulsApi.foodAnalysisResponse.FoodAnalysisApi
import com.example.data.modulsApi.groceryFoodResponse.GroceryFoodApi
import com.example.domain.repositories.pojo.GroceryFoodPojo
import com.example.domain.repositories.pojo.RecipeAnalysisPojo
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