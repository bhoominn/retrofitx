package com.nb.retrofitx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nb.retrofitx.extensions.getApis
import com.nb.retrofitx.extensions.getResponse
import com.nb.retrofitx.extensions.toast
import com.nb.retrofitx.models.RequestModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //GET Api
//        getUser()

        //POST Api
//        createUser()
    }

    private fun createUser() {
        val requestModel = RequestModel()
        requestModel.name = "Bhoomin"

        getResponse(getApis().createUser(requestModel), onApiSuccess = {
            txtName.text = it.name
        }, onApiError = {
            //Handle Api Error
            toast(it)
        }, onNetworkError = {
            //Handle No Internet Connection
        })
    }

    private fun getUser() {
        getResponse(getApis().getUser(), onApiSuccess = {
            txtName.text = it.name
        }, onApiError = {
            //Handle Api Error
            toast(it)
        }, onNetworkError = {
            //Handle No Internet Connection
        })
    }
}
