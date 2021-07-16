package com.coronaapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object  Retrofit_Vaccine {

    const val BASE_URL = "https://vaksincovid19-api.vercel.app/api/"

    val instance: API_Vaccine by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)

            .client( OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build())

            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(API_Vaccine::class.java)
    }
}