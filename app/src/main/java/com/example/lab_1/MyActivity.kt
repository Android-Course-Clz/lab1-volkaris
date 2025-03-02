package com.example.lab_1

import android.app.Activity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.bumptech.glide.Glide

class MyActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout)

        Glide
            .with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/3/3a/Cat03.jpg")
            .into(findViewById(R.id.profilePic))


        var messagebutton=findViewById<ImageButton>(R.id.messageButton);
        var followButton=findViewById<ImageButton>(R.id.followButton)

        messagebutton.setOnClickListener {
            Toast.makeText(this,"Message button was pressed",Toast.LENGTH_SHORT).show()
        }

        followButton.setOnClickListener {
            Toast.makeText(this,"Follow button was pressed",Toast.LENGTH_SHORT).show()
        }

    }
}