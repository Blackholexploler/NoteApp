package com.example.noteapp

import androidx.annotation.DrawableRes

data class NavigationMenu(
    val label: String,
    @DrawableRes val ikon: Int,
    val route: String
)

val MenuList = listOf(
    NavigationMenu("Beranda", R.drawable.ic_home,   "beranda"),
    NavigationMenu("Tambah",  R.drawable.ic_add, "tambah"),
    NavigationMenu("Profil",  R.drawable.ic_person, "profil")
)
