package com.example.quickwebview

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UrlHistoryDao {

    @Insert
    fun insert(entity: UrlHistoryEntity)

    @Query("SELECT * FROM url_history ORDER BY timestamp DESC")
    fun getAll(): LiveData<List<UrlHistoryEntity>>

    @Query("DELETE FROM url_history")
    fun clearAll()
}


