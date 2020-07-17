package com.example.nutritionfacts.data.network

import com.example.nutritionfacts.data.repository.pojo.GroceryFoodPojo
import com.example.nutritionfacts.data.repository.response.foodAnalysisResponse.FoodAnalysisApi
import com.example.nutritionfacts.data.repository.response.groceryFoodResponse.GroceryFoodApi
import com.example.nutritionfacts.data.repository.pojo.RecipeAnalysisPojo
import com.example.nutritionfacts.ui.models.FoodAnalysis
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
  ): Single<FoodAnalysisApi>

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
            /*  val key = "fd7b0a01c554ecad3cffd0a081e38235"
              val id = "34cc042c"
              val requestInterceptor = Interceptor { chain ->
                  val url = chain.request()
                      .url()
                      .newBuilder()
                      .addQueryParameter("app_key", key)
                      .addQueryParameter("app_id", id)
                      .build()
                  val request = chain.request()
                      .newBuilder()
                      .url(url)
                      .build()
                  return@Interceptor chain.proceed(request)
              }

              val okHttpClient = OkHttpClient.Builder()
                  .addInterceptor(requestInterceptor)
                  .build()*/

            return Retrofit.Builder()
                //   .client(okHttpClient)
                .baseUrl("https://api.edamam.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(NutritionAnalysisApiService::class.java)
        }
    }



}