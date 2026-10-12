package com.example.noteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
class CatatanViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = CatatanRepository(
        AppDatabase.ambil(app).catatanDao()
    )
    val daftarCatatan: StateFlow<List<Catatan>> =
        repo.semuaCatatan.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )
    fun simpan(judul: String, isi: String) {
        if (judul.isBlank()) return
        viewModelScope.launch {
            repo.tambah(judul, isi)
        }
    }
}