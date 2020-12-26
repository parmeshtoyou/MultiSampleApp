package com.example.multisampleapp.apis

import com.example.multisampleapp.model.Post
import retrofit2.http.GET

interface ApiServices {

    @GET("/posts")
    suspend fun getPostList(): List<Post>

}