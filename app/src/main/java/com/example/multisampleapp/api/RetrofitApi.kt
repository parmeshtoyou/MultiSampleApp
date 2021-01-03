package com.example.multisampleapp.api

import com.example.multisampleapp.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface RetrofitApi {

    @GET("/")
    fun getFakeResponse() : Observable<User>
}