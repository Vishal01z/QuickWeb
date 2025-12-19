package com.example.quickwebview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickwebview.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var repository: UrlRepository
    private lateinit var adapter: HistoryAdapter

    // ✅ keep latest history here
    private var currentHistory: List<UrlHistoryEntity> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(binding.topAppBar)
        binding.topAppBar.setNavigationOnClickListener { finish() }

        repository = UrlRepository(this)

        adapter = HistoryAdapter { url ->
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", url)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // ✅ Observe ONLY ONCE
        repository.getAllHistory().observe(this) { historyList ->
            currentHistory = historyList
            adapter.submitList(historyList)

            if (historyList.isEmpty()) {
                binding.tvEmpty.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            } else {
                binding.tvEmpty.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
            }
        }

        binding.btnClear.setOnClickListener {
            showClearConfirmation()
        }

        binding.btnUpload.setOnClickListener {
            uploadHistory()
        }
    }

    private fun showClearConfirmation() {
        AlertDialog.Builder(this)
            .setTitle("Clear History")
            .setMessage("Are you sure you want to delete all history?")
            .setPositiveButton("Delete") { _, _ ->
                repository.clearAll()
                Toast.makeText(this, "History cleared", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun uploadHistory() {
        if (currentHistory.isEmpty()) {
            Toast.makeText(this, "No history to upload", Toast.LENGTH_SHORT).show()
            return
        }

        // Dummy upload (assignment requirement)
        currentHistory.forEach {
            android.util.Log.d("UPLOAD", "URL=${it.url}, TIME=${it.timestamp}")
        }

        Toast.makeText(
            this,
            "History uploaded successfully (dummy API)",
            Toast.LENGTH_SHORT
        ).show()
    }
}
