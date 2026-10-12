package com.example.noteapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CatatanDao {
    // CREATE — menyimpan catatan baru
    @Insert
    suspend fun sisipkan(catatan: Catatan)
    // READ — membaca seluruh catatan, yang terbaru di urutan atas
    @Query("SELECT * FROM catatan ORDER BY dibuatPada DESC")
    fun ambilSemua(): Flow<List<Catatan>>
}