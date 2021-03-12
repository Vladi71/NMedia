package ru.netology.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_INDEFINITE
import com.google.android.material.snackbar.Snackbar
import ru.netology.R
import ru.netology.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        val binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

       supportFragmentManager.commit {
           add(R.id.nav_host_fragment, FeedFragment())
       }

        intent?.let {
            if (it.action != Intent.ACTION_SEND) {
                return@let
            }

            val text = it.getStringExtra(Intent.EXTRA_TEXT)
            if (text.isNullOrBlank()) {
                Snackbar.make(binding.root, R.string.error_empty_content, LENGTH_INDEFINITE)
                        .setAction(android.R.string.ok) {
                            finish()
                        }
                        .show()
                return@let
            }
            // TODO: handle text
        }
    }
}
