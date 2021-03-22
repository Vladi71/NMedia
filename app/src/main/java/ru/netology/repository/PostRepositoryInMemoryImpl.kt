package ru.netology.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.map
import ru.netology.dao.PostDao
import ru.netology.dto.Post
import ru.netology.entity.PostEntity

class PostRepositoryImpl(
        private val dao: PostDao,
) : PostRepository {
    override fun getAll() = Transformations.map(dao.getAll()) { list ->
        list.map {
            Post(it.id, it.author, it.content, it.contentVideo, it.published, it.likedByMe,
                    it.numberOfLike, it.numberOfView, it.numberOfShare)
        }
    }


    override fun shareById(id: Long) {
        dao.shareById(id)
    }

    override fun removeBuId(id: Long) {
        dao.removeById(id)
    }

    override fun likeById(id: Long) {
        dao.likeById(id)
    }

    override fun save(post: Post) {
        dao.save(PostEntity.fromDto(post))
    }

}
