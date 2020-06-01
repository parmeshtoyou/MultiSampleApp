package com.example.multisampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory private constructor(): ViewModelProvider.Factory {

    companion object {
        private val hashMapViewModel = HashMap<String, ViewModel>()

        private val myInstance : MyViewModelFactory by lazy {
            MyViewModelFactory()
        }

        fun addViewModel(key: String, viewModel: ViewModel){
            hashMapViewModel.put(key, viewModel)
        }
        fun getViewModel(key: String): ViewModel? {
            return hashMapViewModel[key]
        }

        fun getFactoryInstance() : MyViewModelFactory {
            return myInstance
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommunicatorViewModel::class.java)) {
            val key = "CommunicatorViewModel"
            if(hashMapViewModel.containsKey(key)){
                return getViewModel(key) as T
            } else {
                addViewModel(key, CommunicatorViewModel())
                return getViewModel(key) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}