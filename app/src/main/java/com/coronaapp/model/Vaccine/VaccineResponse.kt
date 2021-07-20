package com.coronaapp.model.Vaccine

import com.google.gson.annotations.SerializedName

data class VaccineResponse(

    @SerializedName("totalsasaran")
    val totalSasaran: Int,
    @SerializedName("sasaranvaksinsdmk")
    val sasaranSdmk: Int,
    @SerializedName("sasaranvaksinlansia")
    val sasaranLansia: Int,
    @SerializedName("sasaranvaksinpetugaspublik")
    val sasaranPetugasPublik: Int,

    @SerializedName("vaksinasi1")
    val gelombangVaksinasi1: Int,
    @SerializedName("vaksinasi2")
    val gelombangVaksinasi2: Int,
    @SerializedName("lastUpdate")
    val lastUpdate: String
)