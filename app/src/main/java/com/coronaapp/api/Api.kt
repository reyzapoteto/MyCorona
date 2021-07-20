package com.coronaapp.api

import com.coronaapp.model.Indonesia.IndonesiaResponse
import com.coronaapp.model.Province.ProvinsiResponse
import com.coronaapp.model.globalResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("/")
    fun getGlobal(): Call<ArrayList<globalResponse>>

    @GET("/indonesia/provinsi")
    fun getProvinsi(): Call<ArrayList<ProvinsiResponse>>

}