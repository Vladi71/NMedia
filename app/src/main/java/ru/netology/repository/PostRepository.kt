package ru.netology.repository

import androidx.lifecycle.LiveData
import ru.netology.Utils
import ru.netology.dto.Post

interface PostRepository {
    fun get(): LiveData<List<Post>>
    fun likeById(id: Long)
    fun shareById(id: Long)


}