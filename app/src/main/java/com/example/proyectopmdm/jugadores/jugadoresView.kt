package com.example.proyectopmdm.jugadores

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController

@Composable
fun jugadoresView(viewModel: JugadoresViewModel, navController: NavController) {
    val jugadores by viewModel.jugadores.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchJugadores()
    }

    Column {
        if (jugadores.isEmpty()) {
            Text(text = "Cargando...")
        }
        else{
            LazyColumn{
                items(jugadores){jugadores ->
                    Text(text = jugadores.numero)
                    Text(text = jugadores.nombre)
                    Text(text = jugadores.posicion)
                    Text(text = jugadores.nacionalidad)
                    Text(text = jugadores.altura)
                    Text(text = jugadores.valorMercado)
                    Text(text = jugadores.img)

                }
            }
        }
    }
}