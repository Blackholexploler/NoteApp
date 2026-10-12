package com.example.noteapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.noteapp.ui.theme.NoteAppTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {
        Greeting("Android")
    }
}

@Composable
fun BarNavigasi(navController: NavHostController) {
    val entri by navController.currentBackStackEntryAsState()
    val ruteSekarang = entri?.destination?.route

    NavigationBar {
        MenuList.forEach { menu ->
            NavigationBarItem(
                selected = ruteSekarang == menu.route,
                onClick  = { navController.pindahKe(menu.route) },
                icon  = { Icon(painterResource(menu.ikon), menu.label) },
                label = { Text(menu.label) }
            )
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BarNavigasi(navController = navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "beranda",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("beranda") {
                WindowHome()
            }

            composable("tambah") {
                WindowAdd()
            }

            composable("profil") {
                ProfileWindow()
            }
        }
    }
}



fun NavHostController.pindahKe(rute: String) {
    navigate(rute) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}


