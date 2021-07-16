package com.coronaapp.model

import com.google.gson.annotations.SerializedName

data class UpdateAddedCovidResponse(

    @SerializedName("positif")
    val positiveCases: Int,

    @SerializedName("meninggal")
     val DeathCases: Int,

    @SerializedName("sembuh")
     val RecoveredCases: Int,

    @SerializedName("dirawat")
     val TreatCases: Int,

     val tanggal: String,

     val created: String
)