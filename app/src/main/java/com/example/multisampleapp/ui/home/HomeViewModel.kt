package com.example.multisampleapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multisampleapp.apis.RetrofitClient
import com.example.multisampleapp.model.Post
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val apiService = RetrofitClient.getNodeService()

    private val mutablePostList = MutableLiveData<List<Post>>()

    val postLiveData: LiveData<List<Post>>
        get() = mutablePostList

    fun getPostList() = viewModelScope.launch { mutablePostList.postValue(apiService.getPostList()) }
}