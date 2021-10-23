package com.coronaapp.api.Retrofit

import com.coronaapp.api.API.Api_DayCovid
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient_Day {
    const val BASE_URL= "https://apicovid19indonesia-v2.vercel.app/api/indonesia/"

    val instance : Api_DayCovid by lazy {

        val retrofit  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client( OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api_DayCovid::class.java)
    }
}
