package com.coronaapp.api.Retrofit

import com.coronaapp.api.API.Api_Hoax
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit_Hoax {

    const val BASE_URL = "https://dekontaminasi.com/api/id/covid19/"


    val instance: Api_Hoax by lazy {

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

        retrofit.create(Api_Hoax::class.java)
    }

}

