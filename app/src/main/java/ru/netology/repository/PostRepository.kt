package ru.netology.repository


import ru.netology.dto.Post
import kotlin.concurrent.thread

interface PostRepository {
    fun getAll(): List<Post>
    fun likeById(id: Long): Post
    fun unLikeById(id: Long): Post
    fun removeById(id: Long)
    fun save(post: Post)


    fun getAllAsync(callback: GetAllCallback)
    fun getPostAsync(id: Long, callback: GetPostCallback)

    interface GetAllCallback {
        fun onSuccess(post: List<Post>) {}
        fun onError(e: Exception) {}
    }

    interface GetPostCallback {
        fun onSuccess(post: Post) {}
        fun onError(e: Exception) {}
    }

}