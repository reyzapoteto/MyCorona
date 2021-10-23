package com.coronaapp.api.Retrofit

import com.coronaapp.api.API.API_Bed_Kosong
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit_Bed_Kosong {

    const val BASE_URL = "https://rs-bed-covid-api.vercel.app/api/"

    val instance : API_Bed_Kosong by lazy {

         val retrofit = Retrofit.Builder()
             .baseUrl(BASE_URL)
             .client(OkHttpClient.Builder()
                 .connectTimeout(10, TimeUnit.SECONDS)
                 .readTimeout(30,TimeUnit.SECONDS)
                 .writeTimeout(30,TimeUnit.SECONDS)
                 .build()
             )
             .addConverterFactory(GsonConverterFactory.create())
             .build()

        retrofit.create(API_Bed_Kosong::class.java)
    }
}