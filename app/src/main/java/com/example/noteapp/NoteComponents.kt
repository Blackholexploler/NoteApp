package com.example.noteapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun KartuCatatan(
    catatan: Catatan,
    onHapus: () -> Unit
) {
    var tampilDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = catatan.judul,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = catatan.isi,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = { tampilDialog = true }
            ) {
                Text("Hapus")
            }
        }
    }

    if (tampilDialog) {
        AlertDialog(
            onDismissRequest = { tampilDialog = false },
            title = { Text("Hapus catatan?") },
            text = {
                Text("Catatan ini akan dihapus secara permanen.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        tampilDialog = false
                        onHapus()
                    }
                ) {
                    Text("Ya, Hapus")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { tampilDialog = false }
                ) {
                    Text("Batal")
                }
            }
        )
    }
}

