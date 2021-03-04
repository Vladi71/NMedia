package ru.netology.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import ru.netology.AndroidUtils
import ru.netology.R
import ru.netology.databinding.ActivityNewPostBinding
import ru.netology.viewModel.PostViewModel

class NewPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)
        val viewModel: PostViewModel by viewModels()
        val binding = ActivityNewPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cancelIv.setOnClickListener {

            with(binding.contentEt) {
                viewModel.cancelChange()
                setText("")
                clearFocus()
                AndroidUtils.hideKeyboard(this)
                finish()
            }
        }
        binding.addIv.setOnClickListener {
            binding.contentVideoEt.visibility = View.VISIBLE

        }

        binding.contentEt.requestFocus()
        binding.contentVideoEt.requestFocus()
        binding.saveIv.setOnClickListener {
            val intent = Intent()
            if (binding.contentEt.text.isNullOrBlank()) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val contentText = binding.contentEt.text.toString()
                intent.putExtra("contentText", contentText)
                setResult(Activity.RESULT_OK, intent)
                val contentVideo = binding.contentVideoEt.text.toString()
                intent.putExtra("contentVideo", contentVideo)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }
    }


}
