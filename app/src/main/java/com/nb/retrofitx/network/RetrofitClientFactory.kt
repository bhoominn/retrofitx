package com.nb.retrofitx.network

import com.nb.retrofitx.App.Companion.apiInterface
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientFactory {
    private val mBaseUrl = "https://raw.githubusercontent.com"

    fun getRestApis(): ApiInterface {
        if (apiInterface != null) {
            return apiInterface!!
        }
        apiInterface = getRetroFitClient()
        return apiInterface!!
    }

    fun getRetroFitClient(): ApiInterface {
        return Retrofit
                .Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiInterface::class.java)
    }
}
