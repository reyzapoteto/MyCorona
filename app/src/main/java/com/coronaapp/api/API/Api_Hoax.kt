package com.coronaapp.api.API

import com.coronaapp.model.Hoax.hoaxmodel
import retrofit2.Call
import retrofit2.http.GET

interface Api_Hoax {

    @GET("hoaxes")
    fun getHoax(): Call<ArrayList<hoaxmodel>>

}