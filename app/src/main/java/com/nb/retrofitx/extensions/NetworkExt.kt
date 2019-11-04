package com.nb.retrofitx.extensions

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.RequiresPermission
import com.nb.retrofitx.App.Companion.apiInterface
import com.nb.retrofitx.App.Companion.getAppInstance
import com.nb.retrofitx.R
import com.nb.retrofitx.network.ApiInterface
import com.nb.retrofitx.network.RetrofitClientFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun getApis(): ApiInterface = apiInterface ?: RetrofitClientFactory().getRestApis()

fun <T> getResponse(call: Call<T>, onApiSuccess: (T) -> Unit = {}, onApiError: (message: String) -> Unit = {}, onNetworkError: () -> Unit = {}) {
    call.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) response.body()?.let {
                onApiSuccess(response.body()!!)
            }
            else {
                onApiError(getCodeStatus(response.code()))
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            if (!isNetworkAvailable()) {
                onNetworkError()
            } else {
                onApiError(getAppInstance().getString(R.string.error_something_went_wrong))
            }
        }
    })
}

@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun isNetworkAvailable(): Boolean {
    val info = getAppInstance().getConnectivityManager().activeNetworkInfo
    return info != null && info.isConnected
}

fun Context.getConnectivityManager() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

fun getCodeStatus(aHttpCode: Int): String {
    return when (aHttpCode) {
        400 -> "Bad Request"
        401 -> "Unauthorized"
        404 -> "URL Not Found"
        407 -> "Proxy Authentication Required"
        408 -> "Request Timeout"
        413 -> "Payload Too Large"
        414 -> "URI Too Long"
        440 -> "Session expire"
        504, 598, 599 -> "Server timeout"
        500 -> "Internal Server Error"
        else -> "Network error"
    }
}