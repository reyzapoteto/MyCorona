package com.coronaapp.model

import com.google.gson.annotations.SerializedName

data class Globalmodel(

    @SerializedName("OBJECTID")
    val objectID: Int,
    @SerializedName("Country_Region")
    val countryName:String,
    @SerializedName("Lat")
    val latitude:Double,
    @SerializedName("Long_")
    val longitude:Double,
    @SerializedName("Confirmed")
    val caseConfirmed:Int,
    @SerializedName("Deaths")
    val caseDeath:Int,
    @SerializedName("Recovered")
    val caseRecovered:Int,
    @SerializedName("Active")
    val caseActive:Int


)