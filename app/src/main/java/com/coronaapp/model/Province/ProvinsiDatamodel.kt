package com.coronaapp.model.Province

import com.google.gson.annotations.SerializedName

data class ProvinsiDatamodel(

    @SerializedName("KodeProvi") // untuk menyamakan aturan penulisan pada kotlin
    val code: Int,

    @SerializedName("provinsi")
    val province: String,

    @SerializedName("kasusPosi")
    val casePositive: Int,

    @SerializedName("kasusSemb")
    val caseRecovered: Int,

    @SerializedName("kasusMeni")
    val caseDeath: Int

)

