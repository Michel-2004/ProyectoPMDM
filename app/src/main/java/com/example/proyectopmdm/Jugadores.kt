package com.example.proyectopmdm


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavController
import com.example.proyectopmdm.jugadores.JugadoresViewModel
import com.example.proyectopmdm.jugadores.jugadoresView

@Composable
fun Jugadores(navController: NavController) {
    jugadoresView(viewModel = JugadoresViewModel())
}