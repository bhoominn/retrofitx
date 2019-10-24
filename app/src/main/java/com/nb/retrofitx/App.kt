package com.nb.retrofitx

import android.app.Application
import com.nb.retrofitx.network.ApiInterface

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        lateinit var app: App
        val apiInterface: ApiInterface? = null

        fun getAppInstance(): App {
            return app
        }
    }
}