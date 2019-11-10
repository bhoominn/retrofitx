package com.nb.retrofitx.extensions

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.RequiresPermission
import com.nb.retrofitx.App.Companion.apiInterface
import com.nb.retrofitx.App.Companion.getAppInstance
import com.nb.retrofitx.network.ApiInterface
import com.nb.retrofitx.network.RetrofitClientFactory

fun getApis(): ApiInterface = apiInterface ?: RetrofitClientFactory().getRestApis()

@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun isNetworkAvailable(): Boolean {
    val info = getAppInstance().getConnectivityManager().activeNetworkInfo
    return info != null && info.isConnected
}

fun Context.getConnectivityManager() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager