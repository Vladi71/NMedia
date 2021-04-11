package ru.netology.repository


import ru.netology.dto.Post
import kotlin.concurrent.thread

interface PostRepository {
    fun getAll(): List<Post>
    fun likeById(id: Long)
    fun unLikeById(id: Long)
    fun removeById(id: Long)
    fun save(post: Post)


}