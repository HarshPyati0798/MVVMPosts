package com.app.mvvmposts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.mvvmposts.R
import com.app.mvvmposts.model.data.Posts
import com.app.mvvmposts.view.adapters.PostsListAdapter
import com.app.mvvmposts.viewmodel.PostsViewModel
import kotlinx.android.synthetic.main.activity_posts.*

class PostsActivity : AppCompatActivity() {
    private lateinit var postsViewModel: PostsViewModel
    private lateinit var postsListAdapter: PostsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        postsViewModel = ViewModelProvider(this).get(PostsViewModel::class.java)
        postsListAdapter = PostsListAdapter(arrayListOf())
        posts.apply {
            layoutManager = LinearLayoutManager(this@PostsActivity)
            adapter = postsListAdapter
        }
        observeForChanges()
    }

    private fun observeForChanges() {
        postsViewModel.listOfPosts.observe(this, Observer {
            it?.let { posts ->
                updateUI(ArrayList(posts))
            }
        })
    }

    private fun updateUI(allPosts: ArrayList<Posts>) {
        postsListAdapter.updateData(allPosts)
    }
}
