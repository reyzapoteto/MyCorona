package com.coronaapp.api.API

import com.coronaapp.model.Hoax.hoaxmodel
import retrofit2.Call
import retrofit2.http.GET

interface Api_News_Covid {

    @GET("news")
    fun getNews(): Call<ArrayList<hoaxmodel>>

}