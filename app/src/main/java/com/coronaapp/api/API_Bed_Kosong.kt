    package com.coronaapp.api

import com.coronaapp.model.Bed_Kosong.All_Provinces.Corona_Bed_Kosong
import com.coronaapp.model.Bed_Kosong.Cities.City_Corona_BedKosong
import com.coronaapp.model.Bed_Kosong.Hospital_Detail.Hospital_Details_BedKosong
import com.coronaapp.model.Bed_Kosong.Hospital_Maps.Hospital_Data_Maps
import com.coronaapp.model.Bed_Kosong.Hospitals.Hospital_Corona_BedKosong
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API_Bed_Kosong {


    @GET("get-provinces")
    fun getAllProvinces(): Call<Corona_Bed_Kosong>

    @GET("get-cities")
    fun getCities(@Query("provinceid") ProvinceId: String): Call<City_Corona_BedKosong>


    @GET("get-hospitals")
    fun getHospitalsCovid(
        @Query("provinceid") ProvinceId: String,
        @Query("cityid") CityId: String,
        @Query("type") type: String
    ): Call<Hospital_Corona_BedKosong>


    @GET("get-hospitals")
    fun getHospitalsNonCovid(
        @Query("provinceid") ProvinceId: String,
        @Query("cityid") CityId: String,
        @Query("type") type: String
    ): Call<Hospital_Corona_BedKosong>


    @GET("get-bed-detail")
    fun getHospitalsDetail(
        @Query("hospitalid") hospitalId: String,
        @Query("type") type: String
    ): Call<Hospital_Details_BedKosong>

    @GET("get-bed-detail")
    fun getHospitalsNonCovidDetail(
        @Query("hospitalid") hospitalId: String,
        @Query("type") type: String
    ): Call<Hospital_Details_BedKosong>

    @GET("get-hospital-map")
    fun getHospitalsDetailMaps(@Query("hospitalid") hospitalId: String): Call<Hospital_Data_Maps>
}