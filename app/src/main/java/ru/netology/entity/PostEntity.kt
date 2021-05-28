package ru.netology.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.dto.Post

@Entity
class PostEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val author: String,
        val authorAvatar: String,
        val content: String,
        val published: Long,
        val likedByMe: Boolean,
        val likes: Int

) {
    fun toDto() = Post(
            id, author, authorAvatar, content, published, likedByMe, likes
    )

    companion object {
        fun fromDto(post: Post): PostEntity = with(post) {
            PostEntity(id, author, authorAvatar, content, published, likedByMe, likes
            )
        }

    }
}
fun List<PostEntity>.toDto(): List<Post> = map(PostEntity::toDto)
fun List<Post>.toEntity(): List<PostEntity> = map(PostEntity::fromDto)