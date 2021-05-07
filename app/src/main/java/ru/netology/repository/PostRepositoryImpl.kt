package ru.netology.repository


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.netology.api.PostsApiService
import ru.netology.dto.Post
import ru.netology.error.ApiError

private fun <T> PostRepository.Callback<T>.retrofitCallback(): Callback<T> =
        object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (!response.isSuccessful) {
                    onError(RuntimeException(response.message()))
                    return
                }
                onSuccess(
                        response.body()
                                ?: throw RuntimeException("body is null")
                )
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                onError(ApiError.fromThrowable(t))
            }
        }


class PostRepositoryImpl : PostRepository {

    override fun getAllAsync(callback: PostRepository.Callback<List<Post>>) {
        PostsApiService.instance.getAll().enqueue(callback.retrofitCallback())
    }

    override fun getPostAsync(id: Long, callback: PostRepository.Callback<Post>) {
        PostsApiService.instance.getById(id).enqueue(callback.retrofitCallback())
    }

    override fun likeById(id: Long, callback: PostRepository.Callback<Post>) {
        PostsApiService.instance.likeById(id).enqueue(callback.retrofitCallback())
    }

    override fun unLikeById(id: Long, callback: PostRepository.Callback<Post>) {
        PostsApiService.instance.dislikeById(id).enqueue(callback.retrofitCallback())
    }

    override fun save(post: Post, callback: PostRepository.Callback<Post>) {
        PostsApiService.instance.save(post).enqueue(callback.retrofitCallback())

    }

    override fun removeById(id: Long, callback: PostRepository.Callback<Unit>) {
        PostsApiService.instance.removeById(id).enqueue(callback.retrofitCallback())
    }
}

