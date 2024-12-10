package com.my.myquote

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.myquote.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getQuote()
        binding.nextBtn.setOnClickListener {
            getQuote()
        }

    }
    private fun getQuote() {
        setInProgress(true)
        GlobalScope.launch {
            try {
                val response = RetrofitInstance.quoteApi.getRandomQuote()
                runOnUiThread {
                    setInProgress(false)
                    if (response.isSuccessful && response.body() != null) {
                        val quote = response.body()!![0]
                        setQuote(quote)
                    } else {
                        binding.quoteTv.text = "Something went wrong"
                    }
                }
            } catch (e: Exception) {
                runOnUiThread {
                    setInProgress(false)
                    binding.quoteTv.text = "Something went wrong"
                    binding.authorTv.text = "....."
                }
            }
        }
    }

    private fun setQuote(quote: QuoteModel) {
        binding.quoteTv.text = quote.q
        binding.authorTv.text = quote.a
    }

    private fun setInProgress(inProgress: Boolean) {
        if (inProgress) {
            binding.progressCircular.visibility = View.VISIBLE
            binding.nextBtn.visibility = View.GONE
        } else {
            binding.progressCircular.visibility = View.GONE
            binding.nextBtn.visibility = View.VISIBLE
        }
    }
}