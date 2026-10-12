package com.example.noteapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catatan")
data class Catatan(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val judul: String,
    val isi: String,
    val dibuatPada: Long = System.currentTimeMillis()
)

