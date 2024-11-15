package com.example.proyectopmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectopmdm.navigation.AppNavigation
import com.example.proyectopmdm.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoPMDMTheme {
               AppNavigation()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    ProyectoPMDMTheme {
        AppNavigation()
    }
}