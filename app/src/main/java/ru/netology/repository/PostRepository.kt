package ru.netology.repository


import ru.netology.dto.Post

interface PostRepository {

    fun likeById(id: Long, callback: Callback<Post>)
    fun unLikeById(id: Long, callback: Callback<Post>)
    fun removeById(id: Long, callback: Callback<Unit>)
    fun save(post: Post, callback: Callback<Post>)


    fun getAllAsync(callback: Callback<List<Post>>)
    fun getPostAsync(id: Long, callback: Callback<Post>)


    interface Callback<T> {
        fun onSuccess(posts: T) {}
        fun onError(e: Exception) {}
    }

}