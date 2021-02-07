package ru.netology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.databinding.ActivityMainBinding
import ru.netology.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
                id = 1,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
                published = "6 февраля в 22:38",
                likedByMe = false,
                numberOfLike = 1099,
                numberOfShare = 28,
                numberOfView = 11
        )
        with(binding) {
            authorTv.text = post.author
            contentTv.text = post.content
            publishedTv.text = post.published
            numberLikeTv.text = Utils.valueUpgrade(post.numberOfLike)
            numberShareTv.text = Utils.valueUpgrade(post.numberOfShare)
            numberViewTv.text = post.numberOfView.toString()
            if (post.likedByMe) {
                likeIb.setImageResource(R.drawable.liked_avatar)

            }
            likeIb.setOnClickListener {
                numberLikeTv.text = if (post.likedByMe) {
                    Utils.valueUpgrade(--post.numberOfLike)
                } else {
                    Utils.valueUpgrade(++post.numberOfLike)
                }

                post.likedByMe = !post.likedByMe
                likeIb.setImageResource(
                        if (post.likedByMe) R.drawable.liked_avatar else R.drawable.like_avatar)

            }
            shareIb.setOnClickListener {
                numberShareTv.text = Utils.valueUpgrade(++post.numberOfShare)
            }
        }
    }
}


