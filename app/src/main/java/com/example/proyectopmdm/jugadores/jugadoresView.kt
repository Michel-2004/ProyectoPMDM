package com.example.proyectopmdm.jugadores

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.proyectopmdm.ui.theme.backgroundLight
import java.lang.reflect.Modifier

@Composable
fun jugadoresView(viewModel: JugadoresViewModel) {
    val jugadores by viewModel.jugadores.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchJugadores()
    }
    Column(modifier = androidx.compose.ui.Modifier.fillMaxSize().background(backgroundLight)
        .wrapContentSize(Alignment.TopCenter).padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (jugadores.isEmpty()) {
            Text(text = "Cargando...")
        }
        else{
            LazyColumn{
                items(jugadores) { jugadores ->
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(jugadores.img.replace("http://", "https://"))
                            .crossfade(true)
                            .build(),
                        contentDescription = jugadores.nombre,
                        contentScale = ContentScale.Fit
                    )
                    Text(text ="Numero: ${jugadores.numero}")
                    Text(text = "Nombre: ${jugadores.nombre}")
                    Text(text = "Posicion: ${jugadores.posicion}")
                    Text(text = "Nacionalidad: ${jugadores.nacionalidad}")
                    Text(text = "Altura: ${jugadores.altura} m")
                    Text(text = "Valor de mercado: ${jugadores.valorMercado}€")
                }
            }
        }
    }
}