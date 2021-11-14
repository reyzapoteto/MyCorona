package com.coronaapp.api.Retrofit

import com.coronaapp.api.API.API_Vaccine
import com.coronaapp.api.API.APi_Provinsi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit_Provinsicovid {

    const val BASE_URL = "https://indonesia-covid-19.mathdro.id/"

    val instance: APi_Provinsi by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)

            .client( OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build())

            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(APi_Provinsi::class.java)
    }

}