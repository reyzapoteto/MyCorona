package com.coronaapp.model.Bed_Kosong.Hospitals

import com.google.gson.annotations.SerializedName

data class Hospital_BedKosong_Datamodel(

    val id: String,
    val name: String,
    val address: String,
    val phone: String,
    val queue: Int,
    @SerializedName("bed_availability")
    val avaliable: Int,
    val info: String

)