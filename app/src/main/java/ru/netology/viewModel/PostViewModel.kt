package ru.netology.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.SingleLiveEvent
import ru.netology.dto.Post
import ru.netology.model.FeedModel
import ru.netology.repository.PostRepository
import ru.netology.repository.PostRepositoryImpl
import java.io.IOException
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.concurrent.Executors
import kotlin.concurrent.thread


private val empty = Post(
        id = 0,
        author = "",
        authorAvatar = "",
        content = "",
        published = "",
        likedByMe = false,
        likes = 0
)

class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PostRepository = PostRepositoryImpl()
    private val _data = MutableLiveData(FeedModel())
    val data: LiveData<FeedModel>
        get() = _data
    val edited = MutableLiveData(empty)
    private val _postCreated = SingleLiveEvent<Unit>()
    val postCreated: LiveData<Unit>
        get() = _postCreated

    private val executorService = Executors.newFixedThreadPool(64)

    init {
        loadPosts()
    }

    fun loadPosts() {
        _data.value = FeedModel(loading = true)
        repository.getAllAsync(object : PostRepository.GetAllCallback {
            override fun onSuccess(posts: List<Post>) {
                _data.postValue(FeedModel(posts = posts, empty = posts.isEmpty()))
            }

            override fun onError(e: Exception) {
                _data.postValue(FeedModel(error = true))
            }
        })
    }

    fun save() {
        edited.value?.let {
            executorService.execute {
                repository.save(it)
                _postCreated.postValue(Unit)
            }
        }
        edited.value = empty
    }


    fun edit(post: Post) {
        edited.value = post
    }

    fun changeContent(content: String) {
        val text = content.trim()
        if (edited.value?.content == text) {
            return
        }
        edited.value = edited.value?.copy(content = text)
    }

    fun likeById(id: Long) = executorService.execute {
        val updatedPost = repository.likeById(id)
        _data.postValue(
                _data.value?.copy(posts = _data.value?.posts.orEmpty()
                        .map { if (it.id != updatedPost.id) it else updatedPost }
                )
        )
    }

    fun unLikeById(id: Long) = executorService.execute {
        val updatedPost = repository.unLikeById(id)
        _data.postValue(
                _data.value?.copy(posts = _data.value?.posts.orEmpty()
                        .map { if (it.id != updatedPost.id) it else updatedPost }
                )
        )
    }


    fun removeById(id: Long) {
        executorService.execute {
            val old = _data.value?.posts.orEmpty()
            _data.postValue(
                    _data.value?.copy(posts = _data.value?.posts.orEmpty()
                            .filter { it.id != id }
                    )
            )
            try {
                repository.removeById(id)
            } catch (e: IOException) {
                _data.postValue(_data.value?.copy(posts = old))
            }
        }
    }

    fun openPost(post: Post) {
        edited.value = post
    }

    fun cancelChange() {
        edited.value = edited.value
    }
}

