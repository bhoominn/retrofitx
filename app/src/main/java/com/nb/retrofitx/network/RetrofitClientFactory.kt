package com.nb.retrofitx.network

import com.google.gson.GsonBuilder
import com.nb.retrofitx.App.Companion.apiInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientFactory {
    private val mBaseUrl = "https://api.github.com/users/"

    fun getRestApis(): ApiInterface {
        if (apiInterface != null) {
            return apiInterface
        }
        return getRetroFitClient().create(ApiInterface::class.java)
    }

    private fun getRetroFitClient(): Retrofit {
        val okHttpClientBuilder = OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES)
        val okHttpClient = okHttpClientBuilder.build()
        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder().baseUrl(mBaseUrl).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson!!)).build()
    }
}
