package com.app.mvvmposts.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvmposts.R
import com.app.mvvmposts.model.data.Posts
import kotlinx.android.synthetic.main.activity_posts.view.*
import kotlinx.android.synthetic.main.post.view.*

class PostsListAdapter(private val postLists: ArrayList<Posts>) :
    RecyclerView.Adapter<PostsListAdapter.PostsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsListViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostsListViewHolder(inflater)
    }

    override fun getItemCount() = postLists.size

    fun updateData(posts: ArrayList<Posts>) {
        postLists.clear()
        postLists.addAll(posts)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PostsListViewHolder, position: Int) {
        val post = postLists[position]
        holder.postTitle.text = post.title
        holder.postBody.text = post.body
    }

    class PostsListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitle: TextView = view.postTitle
        val postBody: TextView = view.postBody
    }
}