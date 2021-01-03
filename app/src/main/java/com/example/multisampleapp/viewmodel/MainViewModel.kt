package com.example.multisampleapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.multisampleapp.api.RetrofitService
import com.example.multisampleapp.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<User>()
    private val compositeDisposable = CompositeDisposable()

    val userLiveData: LiveData<User>
        get() = mutableLiveData

    fun getUser() {
        compositeDisposable.add(
            RetrofitService.getRetrofitService().getFakeResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableLiveData.value = it
                }, {
                    mutableLiveData.value = null
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}