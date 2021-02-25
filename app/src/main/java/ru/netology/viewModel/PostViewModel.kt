package ru.netology.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.dto.Post
import ru.netology.repository.PostRepository
import ru.netology.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun likeById(id: Long) = repository.likeById(id)
    fun shareById(id: Long) = repository.shareById(id)
    fun removeById(id: Long) = repository.removeBuId(id)

    private val empty = Post(
            id = 0,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "",
            published = "18 февраля в 10:12",
            likedByMe = false,
            numberOfLike = 0,
            numberOfShare = 0,
            numberOfView = 0

    )
    val edited = MutableLiveData(empty)

    fun save() {
        edited.value?.let {
            repository.save(it)
        }
        edited.value = empty
    }

    fun changeContent(content: String) {
        edited.value?.let {
            val text = content.trim()
            if (it.content == text) {
                return
            }

            edited.value = it.copy(content = text)

        }
    }
    fun edit(post: Post){
      edited.value = post
    }

    fun  cancelChange(){
        edited.value = edited.value
    }

}