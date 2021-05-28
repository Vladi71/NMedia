package ru.netology.repository


import androidx.lifecycle.LiveData
import ru.netology.dto.Post

interface PostRepository {
    val data: LiveData<List<Post>>
    suspend fun likeById(id: Long)
    suspend fun unLikeById(id: Long)
    suspend fun removeById(id: Long)
    suspend fun save(post: Post)
    suspend fun getAll()
}

