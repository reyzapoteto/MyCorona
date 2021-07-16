package com.coronaapp.api

import com.coronaapp.model.UpdateAddedCovidResponse
import com.coronaapp.model.UpdateCorona
import retrofit2.Call
import retrofit2.http.GET

interface Api_DayCovid {

    @GET("more")

    fun getDailyAdd(): Call<UpdateCorona>
}