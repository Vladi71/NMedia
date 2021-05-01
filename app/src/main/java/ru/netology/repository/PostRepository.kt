package ru.netology.repository


import ru.netology.dto.Post

interface PostRepository {

    fun likeById(id: Long, callback: Callback<Post>)
    fun unLikeById(id: Long, callback: Callback<Post>)
    fun removeById(id: Long, callback: Callback<Unit>)
    fun save(post: Post, callback: Callback<Post>)


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

    interface Callback<T> {
        fun onSuccess(posts: T) {}
        fun onError(e: Exception) {}
    }

}