package com.coronaapp.api.Retrofit

import com.coronaapp.api.API.Api
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "https://api.kawalcorona.com" // baseURL untukk acuan

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)

            .client(
                OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()
            )

            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java) // get API for Retrofit
    }
}