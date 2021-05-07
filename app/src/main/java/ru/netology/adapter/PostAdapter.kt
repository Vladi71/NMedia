package ru.netology.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.netology.R
import ru.netology.Utils
import ru.netology.databinding.CardPostBinding
import ru.netology.dto.Post

interface OnInteractionListener {
    fun onLike(post: Post) {}
    fun onRemove(post: Post) {}
    fun onEdit(post: Post) {}
    fun onCancelEdit(post: Post) {}
    fun onOpenPost(post: Post) {}
}

@Suppress("UNREACHABLE_CODE")
class PostAdapter(
        private val OnInteractionListener: OnInteractionListener,
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
            publishedTv.text = Utils.convertDate()
            likeIb.text = Utils.valueUpgrade(post.likes)
            likeIb.isChecked = post.likedByMe
            val url = "http://10.0.3.2:9999/avatars/${post.authorAvatar}"
            Glide.with(binding.avatarV)
                    .load(url)
                    .transform(RoundedCorners(80))
                    .placeholder(R.drawable.ic_baseline_rotate_right_24)
                    .error(R.drawable.ic_baseline_cloud_off_24)
                    .timeout(10_000)
                    .into(binding.avatarV)

            val urlImg = "http://10.0.3.2:9999/images/${post.attachment?.url}"
            Glide.with(binding.imageIV)
                    .load(urlImg)
                    .placeholder(R.drawable.ic_baseline_rotate_right_24)
                    .error(R.drawable.ic_baseline_cloud_off_24)
                    .timeout(10_000)
                    .into(binding.imageIV)

            if (post.attachment == null ) {
                imageIV.visibility = View.GONE
            } else {
                imageIV.visibility = View.VISIBLE
            }
        }
        binding.likeIb.setOnClickListener {
            OnInteractionListener.onLike(post)
        }

        binding.contentTv.setOnClickListener {
            OnInteractionListener.onOpenPost(post)
        }

        binding.menuIb.setOnClickListener {
            PopupMenu(it.context, it).apply {
                inflate(R.menu.options_post)
                setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.Remove -> {
                            OnInteractionListener.onRemove(post)
                            true
                        }
                        R.id.Edit -> {
                            OnInteractionListener.onEdit(post)
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

