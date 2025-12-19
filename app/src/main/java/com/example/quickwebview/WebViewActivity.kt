package com.example.quickwebview

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.quickwebview.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding
    private var currentUrl: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentUrl = intent.getStringExtra("url") ?: ""

        setSupportActionBar(binding.topAppBar)

        // ⬅ Back → Home (URL retain)
        binding.topAppBar.setNavigationOnClickListener {
            goHome(retainUrl = true)
        }

        // ❌ Close → Home (URL clear)
        binding.btnClose.setOnClickListener {
            goHome(retainUrl = false)
        }

        setupWebView()
        binding.webView.loadUrl(currentUrl)
        binding.tvUrl.text = currentUrl
    }

    private fun setupWebView() {
        binding.webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
        }

        binding.webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progressBar.visibility = View.GONE
                currentUrl = url ?: currentUrl
                binding.tvUrl.text = currentUrl
            }
        }

        binding.webView.webChromeClient = WebChromeClient()
    }

    private fun goHome(retainUrl: Boolean) {
        val intent = Intent(this, MainActivity::class.java)
        if (retainUrl) {
            intent.putExtra("last_url", currentUrl)
        } else {
            intent.putExtra("clear_url", true)
        }
        startActivity(intent)
        finish()
    }
}
