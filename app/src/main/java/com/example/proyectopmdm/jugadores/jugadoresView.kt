package com.example.proyectopmdm.jugadores

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import java.lang.reflect.Modifier

@Composable
fun jugadoresView(viewModel: JugadoresViewModel) {
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
                items(jugadores) { jugadores ->
                    Text(text = jugadores.numero)
                    Text(text = jugadores.nombre)
                    Text(text = jugadores.posicion)
                    Text(text = jugadores.nacionalidad)
                    Text(text = jugadores.altura)
                    Text(text = jugadores.valorMercado)

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(jugadores.img.replace("http://", "https://"))
                            .crossfade(true)
                            .build(),
                        contentDescription = jugadores.nombre,
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}