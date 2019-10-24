package com.nb.retrofitx.network

import com.nb.retrofitx.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("bhoominn")
    fun getUser(): Call<UserResponse>

}