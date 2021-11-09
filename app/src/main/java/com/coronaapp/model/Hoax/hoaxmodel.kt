package com.coronaapp.model.Hoax

import com.google.gson.annotations.SerializedName

data class hoaxmodel(

    @SerializedName("title")
    var titleHoax: String,

    @SerializedName("url")
    var newsUrlHoax: String

)