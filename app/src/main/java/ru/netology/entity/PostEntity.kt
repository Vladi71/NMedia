package ru.netology.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.dto.Post

@Entity
class PostEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val author: String,
        val content: String,
        val contentVideo: String = "",
        val published: String,
        val likedByMe: Boolean = false,
        val numberOfLike: Int,
        val numberOfView: Int,
        val numberOfShare: Int
) {
    fun toDto() = Post(
            id, author, content, contentVideo, published, likedByMe,
            numberOfLike, numberOfView, numberOfShare
    )

    companion object {
        fun fromDto(post: Post): PostEntity = with(post){
            PostEntity(id, author, content, contentVideo, published, likedByMe,
                    numberOfLike, numberOfView, numberOfShare
            )
        }

    }
}