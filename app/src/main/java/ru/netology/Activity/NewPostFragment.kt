package ru.netology.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.netology.AndroidUtils
import ru.netology.R
import ru.netology.databinding.FragmentNewPostBinding
import ru.netology.viewModel.PostViewModel

class NewPostFragment : Fragment() {
    private val viewModel: PostViewModel by viewModels(
            ownerProducer = ::requireParentFragment
    )


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentNewPostBinding.inflate(inflater, container, false)


        binding.cancelIv.setOnClickListener {
            with(binding.contentEt) {
                viewModel.cancelChange()
                setText("")
                clearFocus()
                AndroidUtils.hideKeyboard(this)
                findNavController().navigateUp()
            }
        }


        binding.contentEt.requestFocus()

        binding.saveIv.setOnClickListener {
            if (TextUtils.isEmpty(binding.contentEt.text)) {
                Toast.makeText(
                        requireContext(),
                        getString(R.string.EnterTheText),
                        Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            } else {
                val contentText = binding.contentEt.text.toString()

                viewModel.changeContent(contentText)
                viewModel.save()
                AndroidUtils.hideKeyboard(requireView())
            }
        }
            viewModel.postCreated.observe(viewLifecycleOwner) {
                viewModel.loadPosts()
                findNavController().navigateUp()
            }
        return binding.root
    }
}
