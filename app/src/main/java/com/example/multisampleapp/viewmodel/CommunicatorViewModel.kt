package com.example.multisampleapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommunicatorViewModel: ViewModel() {

    val liveData = MutableLiveData<String>()

    fun setData(value: String) {
        liveData.value = value
    }


}