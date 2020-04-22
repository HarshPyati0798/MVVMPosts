package com.app.mvvmposts.model.repo

import com.app.mvvmposts.model.data.Posts
import com.app.mvvmposts.model.interfaces.ApiCalls
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val apiInterface: ApiCalls

    init {
        val builder = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        apiInterface = builder.create(ApiCalls::class.java)
    }

    suspend fun getPosts(): List<Posts> = apiInterface.getPosts()
}