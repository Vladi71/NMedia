package ru.netology.repository


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.netology.api.PostsApi
import ru.netology.dto.Post
import java.lang.RuntimeException


class PostRepositoryImpl : PostRepository {

    override fun getAllAsync(callback: PostRepository.GetAllCallback) {
        PostsApi.retrofitService.getAll().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (!response.isSuccessful) {
                    callback.onError(java.lang.RuntimeException(response.message()))
                    return
                }

                callback.onSuccess(response.body()
                        ?: throw java.lang.RuntimeException("body is null"))
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun getPostAsync(id: Long, callback: PostRepository.GetPostCallback) {
        PostsApi.retrofitService.getById(id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (!response.isSuccessful) {
                    callback.onError(java.lang.RuntimeException(response.message()))
                    return
                }

                callback.onSuccess(response.body()
                        ?: throw java.lang.RuntimeException("body is null"))
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun likeById(id: Long, callback: PostRepository.Callback<Post>) {
        PostsApi.retrofitService.likeById(id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (!response.isSuccessful) {
                    callback.onError(java.lang.RuntimeException(response.message()))
                    return
                }
                callback.onSuccess(response.body() ?: throw RuntimeException("body is null"))
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


    override fun unLikeById(id: Long, callback: PostRepository.Callback<Post>) {
        PostsApi.retrofitService.dislikeById(id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (!response.isSuccessful) {
                    callback.onError(java.lang.RuntimeException(response.message()))
                    return
                }
                callback.onSuccess(response.body() ?: throw RuntimeException("body is null"))
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun save(post: Post, callback: PostRepository.Callback<Post>) {
        PostsApi.retrofitService.save(post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (!response.isSuccessful) {
                    callback.onError(java.lang.RuntimeException(response.message()))
                    return
                }
                callback.onSuccess(response.body() ?: throw RuntimeException("body is null"))

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    override fun removeById(id: Long, callback: PostRepository.Callback<Unit>) {
        PostsApi.retrofitService.removeById(id).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (!response.isSuccessful) {
                    callback.onError(java.lang.RuntimeException(response.message()))
                    return
                }
                callback.onSuccess(response.body() ?: throw RuntimeException("body is null"))
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}

