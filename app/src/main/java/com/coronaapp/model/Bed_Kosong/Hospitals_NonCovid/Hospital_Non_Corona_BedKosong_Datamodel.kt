package com.coronaapp.model.Bed_Kosong.Hospitals_NonCovid

import com.google.gson.annotations.SerializedName

data class Hospital_Non_Corona_BedKosong_Datamodel(

    val id: String,
    val name: String,
    val address: String,
    val phone: String,
    @SerializedName("available_beds")
    val avaliable: ArrayList<Hospital_Non_Corona_Bed_Details>,
    val info: String

)