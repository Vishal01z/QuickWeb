package com.example.quickwebview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.example.quickwebview.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: UrlRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar as ActionBar (3-dot menu)
        setSupportActionBar(binding.topAppBar)

        repository = UrlRepository(this)

        setupCarousel()
        setupUrlInput()
        setupButtons()
    }

    // ---------------- MENU (3-DOT) ----------------

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_history -> {
                openHistory()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // ---------------- UI SETUP ----------------

    private fun setupCarousel() {
        val images = listOf(
            R.drawable.banner_1,
            R.drawable.banner_2,
            R.drawable.banner_3
        )
        binding.viewPager.adapter = CarouselAdapter(images)
        TabLayoutMediator(binding.tabDots, binding.viewPager) { _, _ -> }.attach()
    }

    private fun setupUrlInput() {
        binding.etUrl.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_GO ||
                (event?.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
            ) {
                handleOpenClick()
                true
            } else {
                false
            }
        }
    }

    private fun setupButtons() {
        binding.btnOpen.setOnClickListener {
            handleOpenClick()
        }

        binding.btnHistory.setOnClickListener {
            openHistory()
        }
    }

    // ---------------- CORE LOGIC ----------------

    private fun handleOpenClick() {
        var input = binding.etUrl.text.toString().trim()

        if (input.isEmpty()) {
            binding.tilUrl.error = "Please enter a URL"
            return
        }

        binding.tilUrl.error = null

        if (!input.startsWith("http://") && !input.startsWith("https://")) {
            input = "https://$input"
        }

        if (!android.util.Patterns.WEB_URL.matcher(input).matches()) {
            binding.tilUrl.error = "Please enter a valid URL"
            return
        }

        // ✅ CONFIRM HISTORY SAVE
        Log.d("HISTORY_TEST", "Saving URL = $input")

        repository.saveUrl(input)

        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url", input)
        startActivity(intent)
    }

    private fun openHistory() {
        startActivity(Intent(this, HistoryActivity::class.java))
    }
}
