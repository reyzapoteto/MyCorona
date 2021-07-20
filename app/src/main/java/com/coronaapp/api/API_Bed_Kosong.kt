package com.coronaapp.api

import com.coronaapp.model.Bed_Kosong.All_Provinces.Corona_Bed_Kosong
import com.coronaapp.model.Bed_Kosong.Cities.Province_Corona_BedKosong
import com.coronaapp.model.Bed_Kosong.Hospitals.Hospital_Corona_BedKosong
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API_Bed_Kosong {


    @GET("get-provinces")
    fun getAllProvinces(): Call<Corona_Bed_Kosong>

    @GET("get-cities?provinceid={id}")
    fun getCities(@Path("id") ProvinceId: String): Call<Province_Corona_BedKosong>

    @GET("get-hospitals?provinceid={id}&cityid={cityId}&type=1")
    fun getHospitals(@Path("id") ProvinceId: String,
                     @Path("cityId") CityID :String) :Call<Hospital_Corona_BedKosong>
}