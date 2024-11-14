package com.example.proyectopmdm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.proyectopmdm.ui.theme.*

@Composable
fun Configuracion(navController: NavController) {
    ProyectoPMDMTheme {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.onPrimary)
                .wrapContentSize(Alignment.Center)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "volver",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
                    .wrapContentSize(Alignment.TopEnd)
            )
            Text(
                modifier = Modifier.align(CenterHorizontally),
                text = "Configuracion",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontFamily = FontFamily.Serif


            )
            Image(
                painter = painterResource(id = R.drawable.ajustes),
                contentDescription = "ajustes",
            )

            Row(
                modifier = Modifier.align(CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically

            ) {
                
            }
        }
    }
}