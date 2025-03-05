package com.example.lab_1.models

class Post (var id: Int, var text : String,var imageUrl : String, var amountOfComments : String, var amountOfLikes : String){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (text != other.text) return false
        if (imageUrl != other.imageUrl) return false
        if (amountOfComments != other.amountOfComments) return false
        if (amountOfLikes != other.amountOfLikes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = text.hashCode()
        result = 31 * result + imageUrl.hashCode()
        result = 31 * result + amountOfComments.hashCode()
        result = 31 * result + amountOfLikes.hashCode()
        return result
    }
}