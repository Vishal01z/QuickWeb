package com.example.quickwebview

import android.content.Context

class UrlRepository(context: Context) {

    private val dao = AppDatabase.get(context).dao()

    fun saveUrl(url: String) {
        dao.insert(
            UrlHistoryEntity(
                url = url,
                timestamp = System.currentTimeMillis()
            )
        )
    }

    fun getAllHistory() = dao.getAll()

    fun clearAll() = dao.clearAll()
}
