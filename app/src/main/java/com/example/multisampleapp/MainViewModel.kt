package com.example.multisampleapp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.multisampleapp.repository.SomeRepository

class MainViewModel @ViewModelInject constructor(private val someRepository: SomeRepository) : ViewModel() {

    fun getData() = someRepository.loadData().joinToString(separator = " ")
}