package ru.netology.repository


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import ru.netology.api.PostsApi
import ru.netology.dto.Post
import java.io.IOException
import java.util.concurrent.TimeUnit


class PostRepositoryImpl : PostRepository {
    private val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    private val gson = Gson()
    private val typeToken = object : TypeToken<List<Post>>() {}
    private val typePostToken = object : TypeToken<Post>() {}

    companion object {
        private const val BASE_URL = "http://10.0.3.2:9999/api"
        private val jsonType = "application/json".toMediaType()
    }

    override fun getAll(): List<Post> {
        val request: Request = Request.Builder()
                .url("${BASE_URL}/posts")
                .build()

        return client.newCall(request)
                .execute()
                .let { it.body?.string() ?: throw RuntimeException("body is null") }
                .let {
                    gson.fromJson(it, typeToken.type)
                }
    }

    override fun getAllAsync(callback: PostRepository.GetAllCallback) {
        val request: Request = Request.Builder()
                .url("${BASE_URL}/posts")
                .build()
        client.newCall(request)
                .enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        callback.onError(e)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        val body = response.body?.string() ?: throw RuntimeException("body is null")
                        try {
                            callback.onSuccess(gson.fromJson(body, typeToken.type))
                        } catch (e: Exception) {
                            callback.onError(e)
                        }
                    }

                })
    }

    override fun getPostAsync(id: Long, callback: PostRepository.GetPostCallback) {
        PostsApi.retrofitService.getAll().enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(call: retrofit2.Call<List<Post>>, response: retrofit2.Response<List<Post>>) {
                if (!response.isSuccessful) {
                    callback.onError(java.lang.RuntimeException(response.message()))
                    return
                }

                callback.onSuccess(response.body()
                        ?: throw java.lang.RuntimeException("body is null"))
            }

            override fun onFailure(call: retrofit2.Call<List<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun likeById(id: Long): Post {
        val request: Request = Request.Builder()
                .method("POST", body = "".toRequestBody())
                .url("${BASE_URL}/posts/$id/likes")
                .build()

        return client.newCall(request)
                .execute()
                .use {
                    it.body?.string()
                }
                .let {
                    gson.fromJson(it, typePostToken.type)
                }
    }


    override fun unLikeById(id: Long): Post {
        val request: Request = Request.Builder()
                .delete()
                .url("${BASE_URL}/posts/$id/likes")
                .build()

        return client.newCall(request)
                .execute()
                .use {
                    it.body?.string()
                }
                .let {
                    gson.fromJson(it, typePostToken.type)
                }
    }



    override fun save(post: Post) {
        val request: Request = Request.Builder()
                .post(gson.toJson(post).toRequestBody(jsonType))
                .url("${BASE_URL}/posts")
                .build()

        client.newCall(request)
                .execute()

    }


    override fun removeById(id: Long) {
        val request: Request = Request.Builder()
                .delete()
                .url("${BASE_URL}/posts/$id")
                .build()

        client.newCall(request)
                .execute()
                .close()
    }
}


