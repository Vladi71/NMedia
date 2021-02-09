package ru.netology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.databinding.ActivityMainBinding
import ru.netology.dto.Post
import ru.netology.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                authorTv.text = post.author
                contentTv.text = post.content
                publishedTv.text = post.published
                numberLikeTv.text = Utils.valueUpgrade(post.numberOfLike)
                numberShareTv.text = Utils.valueUpgrade(post.numberOfShare)
                numberViewTv.text = post.numberOfView.toString()
                likeIb.setImageResource(
                        if (post.likedByMe) R.drawable.liked_avatar else R.drawable.like_avatar
                )
            }
        }
        binding.likeIb.setOnClickListener {
            viewModel.like()
        }
        binding.shareIb.setOnClickListener {
            viewModel.share()
        }
    }
}


