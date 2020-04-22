package com.app.mvvmposts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.app.mvvmposts.model.data.Posts
import com.app.mvvmposts.model.repo.ApiClient

class PostsViewModel(application: Application) : AndroidViewModel(application) {
    val apiClient = ApiClient()

    val listOfPosts: LiveData<List<Posts>> = liveData {
        val posts = apiClient.getPosts()
        emit(posts)
    }
}