package com.my.myquote

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.my.myquote.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply the saved theme before setting the content view
        if (ThemeManager.isDarkModeEnabled(this)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        super.onCreate(savedInstanceState)

        updateStatusBarTheme()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getQuote()
        handleTheme()

        // Set listener for fetching the next quote
        binding.nextBtn.setOnClickListener {
            getQuote()
        }
    }

    private fun handleTheme() {
        binding.themeButton.setOnClickListener {
            ThemeManager.toggleTheme(this) // Toggle between light and dark themes
            updateStatusBarTheme() // Update status bar theme
            recreate() // Recreate activity to reflect the theme change
        }
    }

    private fun getQuote() {
        setInProgress(true)
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.quoteApi.getRandomQuote()
                setInProgress(false)
                if (response.isSuccessful && response.body() != null) {
                    val quote = response.body()!![0]
                    setQuote(quote)
                } else {
                    binding.quoteTv.text = "Something went wrong"
                }
            } catch (e: Exception) {
                setInProgress(false)
                binding.quoteTv.text = "Something went wrong"
                binding.authorTv.text = "....."
            }
        }
    }

    private fun setQuote(quote: QuoteModel) {
        binding.quoteTv.text = quote.q
        binding.authorTv.text = quote.a
    }

    private fun setInProgress(inProgress: Boolean) {
        binding.progressCircular.visibility = if (inProgress) View.VISIBLE else View.GONE
        binding.nextBtn.visibility = if (inProgress) View.GONE else View.VISIBLE
    }

    private fun updateStatusBarTheme() {
        if (ThemeManager.isDarkModeEnabled(this)) {
            window.decorView.systemUiVisibility = 0 // Clear light mode flags
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR // Light status bar
        }
    }

}
