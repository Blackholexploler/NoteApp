package com.example.noteapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Catatan::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catatanDao(): CatatanDao
    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun ambil(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "coba.db"
                ).build().also { INSTANCE = it }
            }
    }
}