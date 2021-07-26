package com.coronaapp.model.Bed_Kosong.Hospital_Detail

import com.google.gson.annotations.SerializedName

class StasDetail_Datamodel(

    val title: String,
    @SerializedName("bed_available")
    val bedTersedia: Int,
    @SerializedName("bed_empty")
    val bedKosong: Int,
    val queue: Int

)