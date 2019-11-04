package com.nb.retrofitx.network

import com.nb.retrofitx.models.Country
import com.nb.retrofitx.models.UserResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Single<ArrayList<Country>>
}