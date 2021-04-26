package ru.netology.Activity


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.netology.R
import ru.netology.Utils
import ru.netology.databinding.FragmentPostBinding
import ru.netology.viewModel.PostViewModel

class PostFragment : Fragment() {

    private val viewModel: PostViewModel by viewModels(
            ownerProducer = ::requireParentFragment
    )

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

        val binding = FragmentPostBinding.inflate(inflater, container, false)

        val id = arguments?.getLong("id") ?: 0
        viewModel.data.observe(viewLifecycleOwner) {
            val post = it.posts.find { post -> post.id == id } ?: return@observe
            binding.contentTv.text = post.content
            binding.likeIb.isChecked = post.likedByMe
            binding.likeIb.text = post.likes.toString()
            binding.publishedTv.text = Utils.convertDate(post.published)

            val url = "http://10.0.3.2:9999/avatars/${post.authorAvatar}"
            Glide.with(binding.avatarV)
                    .load(url)
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
                binding.imageIV.visibility = View.GONE
            } else {
               binding.imageIV.visibility = View.VISIBLE
            }

            binding.likeIb.setOnClickListener {
                if (!post.likedByMe) {
                    viewModel.likeById(post.id)
                } else {
                    viewModel.unLikeById(post.id)
                }
            }

            binding.menuIb.setOnClickListener {
                PopupMenu(it.context, it).apply {
                    inflate(R.menu.options_post)
                    setOnMenuItemClickListener { item ->
                        when (item.itemId) {
                            R.id.Remove -> {
                                viewModel.removeById(post.id)
                                findNavController().navigateUp()
                                true
                            }
                            R.id.Edit -> {
                                viewModel.edit(post)
                                val bundle = Bundle()
                                bundle.putString("text", post.content)
                                findNavController().navigate(R.id.action_postFragment_to_editPostFragment, bundle)

                                true
                            }
                            else -> false
                        }
                    }
                }.show()
            }
        }

        return binding.root
    }
}