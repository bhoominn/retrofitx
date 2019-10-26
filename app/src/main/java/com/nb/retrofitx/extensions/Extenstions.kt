package com.nb.retrofitx.extensions

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.nb.retrofitx.App.Companion.getAppInstance
import com.nb.retrofitx.R

fun Activity.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
fun Fragment.toast(msg: String) {
    toast(msg)
}

fun Activity.toast(@StringRes msg: Int) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
fun Fragment.toast(@StringRes msg: Int) {
    toast(msg)
}

fun logMessage(aMsg: String) = Log.d(getAppInstance().getString(R.string.app_name), aMsg)
fun logError(aMsg: String) = Log.e(getAppInstance().getString(R.string.app_name), aMsg)
