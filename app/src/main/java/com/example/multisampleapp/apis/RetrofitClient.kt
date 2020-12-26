package com.example.multisampleapp.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val API_SERVICES: ApiServices

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        API_SERVICES = retrofit.create(ApiServices::class.java)
    }

    fun getNodeService() = API_SERVICES
}