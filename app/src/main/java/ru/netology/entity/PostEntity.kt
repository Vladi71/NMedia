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
        val published: String,
        val likedByMe: Boolean,
        val likes: Int
) {
    fun toDto() = Post(
            id, author, content, published, likedByMe, likes
    )

    companion object {
        fun fromDto(post: Post): PostEntity = with(post){
            PostEntity(id, author, content, published, likedByMe, likes
            )
        }

    }
}