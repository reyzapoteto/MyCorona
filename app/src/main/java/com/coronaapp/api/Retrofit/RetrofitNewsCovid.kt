package com.coronaapp.api.Retrofit

import com.coronaapp.api.API.Api_Hoax
import com.coronaapp.api.API.Api_News_Covid
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitNewsCovid {

    const val BASE_URL = "https://dekontaminasi.com/api/id/covid19/"


    val instance: Api_News_Covid by lazy {

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

        retrofit.create(Api_News_Covid::class.java)
    }
}