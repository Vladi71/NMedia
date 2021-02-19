package ru.netology.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.R
import ru.netology.Utils
import ru.netology.databinding.CardPostBinding
import ru.netology.dto.Post

interface OnInteractionListener {
    fun onLike(post: Post) {}
    fun OnShare(post: Post) {}
    fun OnRemove(post: Post) {}
    fun OnEdit(post: Post) {}

}

class PostAdapter(
        private val OnInteractionListener: OnInteractionListener
) :
        ListAdapter<Post, PostViewHolder>(PostDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, OnInteractionListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

class PostViewHolder(
        private val binding: CardPostBinding,
        private val OnInteractionListener: OnInteractionListener,

        ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
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
        binding.likeIb.setOnClickListener {
            OnInteractionListener.onLike(post)
        }
        binding.shareIb.setOnClickListener {
            OnInteractionListener.OnShare(post)
        }

        binding.menuIb.setOnClickListener {
            PopupMenu(it.context, it).apply {
                inflate(R.menu.options_post)
                setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.Remove -> {
                            OnInteractionListener.OnRemove(post)
                            true
                        }
                        R.id.Edit -> {
                            OnInteractionListener.OnEdit(post)
                            true
                        }
                        else -> false
                    }
                }
            }.show()
        }
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

}

