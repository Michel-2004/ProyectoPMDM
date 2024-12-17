package com.example.proyectopmdm


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavController
import com.example.proyectopmdm.jugadores.JugadoresViewModel
import com.example.proyectopmdm.jugadores.jugadoresView

@Composable
fun Jugadores(navController: NavController) {
        jugadoresView(viewModel = JugadoresViewModel())
}