package com.example.data.network.retrofit

import com.example.data.modulsApi.translateResponse.TranslateApi
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface TranslateApiService {

    @GET("/api/v1.5/tr.json/translate")
    fun translate(
        @Query("text") text: String,
        @Query("lang") language: String
    ): Single<TranslateApi>

    companion object{
      operator  fun invoke() : TranslateApiService {
          val key = "trnsl.1.1.20200316T185607Z.c79734beb20fae8b.2480698b7a80a095e118bd5d5f598579718fa473"

          val requestInterceptor =  Interceptor{chain ->
              val url = chain.request()
                  .url()
                  .newBuilder()
                  .addQueryParameter("key", key)
                  .build()
              val request = chain.request()
                  .newBuilder()
                  .url(url)
                  .build()
              return@Interceptor chain.proceed(request)
          }

          val okHttpClient = OkHttpClient.Builder()
              .addInterceptor(requestInterceptor)
              .build()

          return Retrofit.Builder()
              .baseUrl("https://translate.yandex.net")
              .client(okHttpClient)
              .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
              .addConverterFactory(GsonConverterFactory.create())
              .build()
              .create(TranslateApiService::class.java)
      }
    }

}