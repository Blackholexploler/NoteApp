package com.example.noteapp

import kotlinx.coroutines.flow.Flow
class CatatanRepository(private val dao: CatatanDao) {
    val semuaCatatan: Flow<List<Catatan>> = dao.ambilSemua()
    suspend fun tambah(judul: String, isi: String) {
        dao.sisipkan(Catatan(judul = judul, isi = isi))
    }
}
