package com.example.lab_1.Utility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_1.R
import com.example.lab_1.models.Post

class PostAdapter(
    private val onLikeClicked: (Post) -> Unit,
    private val onReplyClicked: (Post) -> Unit
) : ListAdapter<Post,PostAdapter.PostViewHolder>(PostDiffCallback()) {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var postText: TextView = itemView.findViewById(R.id.postText);
        private var postImage: ImageView = itemView.findViewById(R.id.postImage);
        private var amountOfComments : TextView = itemView.findViewById(R.id.comments);
        private var amountOfLikes : TextView = itemView.findViewById(R.id.likes);
        private val likeImage: ImageButton = itemView.findViewById(R.id.likeImage)
        private val replyButton: ImageButton = itemView.findViewById(R.id.replyButton)

        fun bind(post: Post, onLikeClicked: (Post) -> Unit, onReplyClicked: (Post) -> Unit) {
            postText.text = post.text;
            postImage.visibility = View.VISIBLE;

            Glide
                .with(itemView)
                .load(post.imageUrl)
                .into(postImage)

            amountOfLikes.text = post.amountOfLikes;
            amountOfComments.text= post.amountOfComments;


            likeImage.setOnClickListener { onLikeClicked(post) }
            replyButton.setOnClickListener { onReplyClicked(post) }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        var view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.post, parent, false);

        return PostViewHolder(view);


    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post, onLikeClicked, onReplyClicked)
    }

}

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}



