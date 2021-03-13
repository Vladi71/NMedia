package ru.netology.Activity

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.netology.AndroidUtils
import ru.netology.databinding.FragmentEditPostBinding
import ru.netology.viewModel.PostViewModel

class EditPostFragment : Fragment() {

    private val viewModel: PostViewModel by viewModels(
            ownerProducer = ::requireParentFragment
    )

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentEditPostBinding.inflate(inflater, container, false)


        binding.cancelIv.setOnClickListener {

            with(binding.contentEt) {
                viewModel.cancelChange()
                setText("")
                clearFocus()
                AndroidUtils.hideKeyboard(this)
                findNavController().navigateUp()
            }
        }
//        binding.contentEt.text = arguments?.get("text") as Editable?
//        binding.contentEt.text = arguments?.get("video") as Editable?




        binding.contentVideoEt.requestFocus()
        binding.contentEt.requestFocus()
        binding.saveIv.setOnClickListener {
            val contentText = binding.contentEt.text.toString()
            val contentVideo = binding.contentVideoEt.text.toString()
            viewModel.changeContent(contentText, contentVideo)
            viewModel.save()
            findNavController().navigateUp()
        }

        return binding.root
    }

}

