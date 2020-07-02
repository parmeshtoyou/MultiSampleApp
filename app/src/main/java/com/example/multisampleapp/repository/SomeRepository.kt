package com.example.multisampleapp.repository

import javax.inject.Inject

interface SomeRepository {
    fun loadData() : List<String>
}

class SomeRepositoryImpl @Inject constructor() : SomeRepository {
    override fun loadData(): List<String> {
        return listOf("Hello", "World", "!")
    }
}