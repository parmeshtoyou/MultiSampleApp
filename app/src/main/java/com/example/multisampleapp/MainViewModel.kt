package com.example.multisampleapp

import androidx.lifecycle.ViewModel
import com.example.multisampleapp.repository.SomeRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val someRepository: SomeRepository) : ViewModel() {

    fun getData() = someRepository.loadData().joinToString(separator = " ")
}