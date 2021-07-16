package com.coronaapp.model

import com.google.gson.annotations.SerializedName

data class ProvinsiDatamodel(

    @SerializedName("Kode_Provi") // untuk menyamakan aturan penulisan pada kotlin
    val code: Int,

    @SerializedName("Provinsi")
    val province: String,

    @SerializedName("Kasus_Posi")
    val casePositive: Int,

    @SerializedName("Kasus_Semb")
    val caseRecovered: Int,

    @SerializedName("Kasus_Meni")
    val caseDeath: Int

)

