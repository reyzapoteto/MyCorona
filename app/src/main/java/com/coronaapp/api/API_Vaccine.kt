package com.coronaapp.api

import com.coronaapp.model.VaccineResponse
import retrofit2.Call
import retrofit2.http.GET

interface API_Vaccine {

    @GET("vaksin")
    fun getVaccine() :Call<VaccineResponse>
}