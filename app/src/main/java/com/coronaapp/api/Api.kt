package com.coronaapp.api

import com.coronaapp.model.globalResponse
import com.coronaapp.model.indonesiaResponse
import com.coronaapp.model.provinsiResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/indonesia")
    fun getIndonesia(): Call<ArrayList<indonesiaResponse>>

    @GET("/")
    fun getGlobal(): Call<ArrayList<globalResponse>>

    @GET("/indonesia/provinsi")
    fun getProvinsi(): Call<ArrayList<provinsiResponse>>

}