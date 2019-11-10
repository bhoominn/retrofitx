package com.nb.retrofitx.network

import com.nb.retrofitx.models.Country
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Single<ArrayList<Country>>
}