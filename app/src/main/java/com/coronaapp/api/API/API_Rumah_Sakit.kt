package com.coronaapp.api.API

import com.coronaapp.model.RumahSakitResponse
import retrofit2.Call
import retrofit2.http.GET

interface API_Rumah_Sakit {

    @GET("hospitals")
    fun getHospital() : Call<ArrayList<RumahSakitResponse>>



}