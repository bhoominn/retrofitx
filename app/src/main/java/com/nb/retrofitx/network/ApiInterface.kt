package com.nb.retrofitx.network

import com.nb.retrofitx.models.RequestModel
import com.nb.retrofitx.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface ApiInterface {

    @GET("bhoominn")
    fun getUser(): Call<UserResponse>

    @GET("create-user")
    fun createUser(@Body request : RequestModel): Call<UserResponse>

}