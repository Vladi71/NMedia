package ru.netology.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.R

class EditPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_post)
    }
}