package com.app.mvvmposts.model.interfaces

import com.app.mvvmposts.model.data.Posts
import retrofit2.http.GET

interface ApiCalls {
    @GET("/posts")
    suspend fun getPosts(): List<Posts>
}