package ru.netology.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import ru.netology.AndroidUtils
import ru.netology.R
import ru.netology.databinding.ActivityEditPostBinding
import ru.netology.databinding.ActivityNewPostBinding
import ru.netology.viewModel.PostViewModel

class EditPostActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_post)
        val viewModel: PostViewModel by viewModels()
        val binding = ActivityEditPostBinding.inflate(layoutInflater)
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

        binding.contentEt.setText(intent.getStringExtra("text"))
        binding.contentVideoEt.setText(intent.getStringExtra("video"))

        binding.contentVideoEt.requestFocus()
        binding.contentEt.requestFocus()
        binding.saveIv.setOnClickListener {
            val intent = Intent()
            if (binding.contentEt.text.isNullOrBlank()) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val contentText = binding.contentEt.text.toString()
                intent.putExtra("edContentText", contentText)
                setResult(Activity.RESULT_OK, intent)
                val contentVideo = binding.contentVideoEt.text.toString()
                intent.putExtra("edContentVideo", contentVideo)
                setResult(Activity.RESULT_OK, intent)

            }
            finish()
        }
    }
}
