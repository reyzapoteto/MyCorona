package com.coronaapp.api.API

import com.coronaapp.model.Province.ProvinsiResponse
import retrofit2.Call
import retrofit2.http.GET

interface APi_Provinsi {


    @GET("api/provinsi")

    fun getProvinsi(): Call<ProvinsiResponse>
}