package com.coronaapp.api.API

import com.coronaapp.model.Vaccine.VaccineResponse
import retrofit2.Call
import retrofit2.http.GET

interface API_Vaccine {

    @GET("vaksin")
    fun getVaccine() :Call<VaccineResponse>
}