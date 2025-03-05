package com.example.lab_1

import android.app.Activity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_1.Utility.PostAdapter
import com.example.lab_1.models.Post

class MyActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)


        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/3/3a/Cat03.jpg")
            .into(findViewById(R.id.profilePic))


        var messageButton = findViewById<ImageButton>(R.id.messageButton)
        var followButton = findViewById<ImageButton>(R.id.followButton)

        messageButton.setOnClickListener {
            Toast.makeText(this, "Message button was pressed", Toast.LENGTH_SHORT).show()
        }

        followButton.setOnClickListener {
            Toast.makeText(this, "Follow button was pressed", Toast.LENGTH_SHORT).show()
        }

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        var adapter = PostAdapter(
            onLikeClicked = { post ->
                Toast.makeText(this, "Like button pressed on post: ${post.id}", Toast.LENGTH_SHORT).show()
            },
            onReplyClicked = { post ->
                Toast.makeText(this, "Reply button pressed on post: ${post.id}", Toast.LENGTH_SHORT).show()
            }
        )
        recyclerView.adapter = adapter

        var posts = listOf(
            Post(1,
                "How do you do, fellow kids?",
                "https://upload.wikimedia.org/wikipedia/commons/3/3a/Cat03.jpg",
                "1 billions comments", "2 billion likes"),
            Post(2,
                "I heard that you must earn 300k to be satisfied",
                "https://upload.wikimedia.org/wikipedia/commons/4/4d/Cat_November_2010-1a.jpg",
                "10 billions comments", "3 billion likes"),
            Post(3,
                "Am I right?",
                "https://upload.wikimedia.org/wikipedia/commons/4/4d/Cat_November_2010-1a.jpg",
                "3 billions comments", "4 billion likes")
        )

        adapter.submitList(posts)
    }
}
