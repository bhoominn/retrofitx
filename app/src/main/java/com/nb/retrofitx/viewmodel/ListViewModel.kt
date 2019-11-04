package com.nb.retrofitx.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nb.retrofitx.extensions.getApis
import com.nb.retrofitx.models.Country
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

class ListViewModel : ViewModel(){

    // Viewmodel Class File

    val countries = MutableLiveData<ArrayList<Country>>()
    val loading = MutableLiveData<Boolean>()

    val disposable = CompositeDisposable()

    fun refresh(){
        fetchCountries()
    }

    fun fetchCountries(){
        loading.value = true
        disposable.add(
            getApis()
                .getCountries()
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<ArrayList<Country>>(){
                    override fun onSuccess(value: ArrayList<Country>?) {
                        loading.value = false
                        countries.value = value
                    }

                    override fun onError(e: Throwable?) {
                        loading.value = false
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}