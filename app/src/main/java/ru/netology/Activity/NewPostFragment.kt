package ru.netology.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.netology.AndroidUtils
import ru.netology.databinding.FragmentNewPostBinding
import ru.netology.viewModel.PostViewModel

class NewPostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel: PostViewModel by viewModels()
        val binding = FragmentNewPostBinding.inflate(inflater, container, false)


        binding.cancelIv.setOnClickListener {
            with(binding.contentEt) {
                viewModel.cancelChange()
                setText("")
                clearFocus()
                AndroidUtils.hideKeyboard(this)

            }
        }
        binding.addIv.setOnClickListener {
            if (binding.contentVideoEt.isVisible) {
                binding.contentVideoEt.visibility = View.GONE
            } else {
                binding.contentVideoEt.visibility = VISIBLE
            }
        }

        binding.contentEt.requestFocus()
        binding.contentVideoEt.requestFocus()
        binding.saveIv.setOnClickListener {
            val intent = Intent()
            if (TextUtils.isEmpty(binding.contentEt.text)) {
                activity?.setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val contentText = binding.contentEt.text.toString()
                intent.putExtra("contentText", contentText)
                activity?.setResult(Activity.RESULT_OK, intent)
                val contentVideo = binding.contentVideoEt.text.toString()
                intent.putExtra("contentVideo", contentVideo)
                activity?.setResult(Activity.RESULT_OK, intent)
            }
            findNavController().navigateUp()
        }
        return binding.root
    }
}
