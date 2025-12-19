package com.example.quickwebview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UrlHistoryEntity::class],
    version = 2, // 🔥 MUST be incremented
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dao(): UrlHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun get(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "quick_webview_db"
                )
                    // 🔥 REQUIRED because entity structure changed
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
