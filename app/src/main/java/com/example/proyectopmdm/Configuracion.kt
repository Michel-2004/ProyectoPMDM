@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.proyectopmdm

import android.widget.RadioGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectopmdm.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalContext
import com.example.proyectopmdm.datos.ConfiguracionDataStore

@Composable
fun Configuracion(navController: NavController) {
    // Crear una instancia del DataStore
    val context = LocalContext.current
    val configuracionDataStore = ConfiguracionDataStore(context)

    // Estados para mostrar datos guardados
    val generoGuardado by configuracionDataStore.genero.collectAsState(initial = "")
    val verLigaGuardado by configuracionDataStore.verPartidosLiga.collectAsState(initial = false)
    val verAmistososGuardado by configuracionDataStore.verPartidosAmistosos.collectAsState(initial = false)
    val verInternacionalesGuardado by configuracionDataStore.verPartidosInternacionales.collectAsState(initial = false)
    val numeroGuardado by configuracionDataStore.numeroSeleccionado.collectAsState(initial = 1)

    // Variables de estado para los valores seleccionados
    val genero = remember { mutableStateOf(generoGuardado ?: "") }
    val verPartidosLiga = remember { mutableStateOf(verLigaGuardado) }
    val verPartidosAmistosos = remember { mutableStateOf(verAmistososGuardado) }
    val verPartidosInternacionales = remember { mutableStateOf(verInternacionalesGuardado) }
    val selectedNumber = remember { mutableStateOf(numeroGuardado) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background) // Fondo adaptativo
            .padding(16.dp)
    ) {
        // Icono de volver
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.volver),
            modifier = Modifier
                .clickable { navController.popBackStack() }
                .wrapContentSize(Alignment.TopEnd)
        )

        // Título
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.configuracion_titulo),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.headlineSmall
        )

        // Imagen
        Image(
            painter = painterResource(id = R.drawable.ajustes),
            contentDescription = stringResource(id = R.string.ajustes),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Género
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Opciones de género
            RadioButton(
                selected = genero.value == "Masculino",
                onClick = { genero.value = "Masculino" }
            )
            Text(
                text = stringResource(id = R.string.genero_masculino),
                modifier = Modifier.padding(start = 8.dp)
            )

            RadioButton(
                selected = genero.value == "Femenino",
                onClick = { genero.value = "Femenino" }
            )
            Text(
                text = stringResource(id = R.string.genero_femenino),
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        // Opciones adicionales de configuración
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            // Variables para opciones adicionales
            var expanded by remember { mutableStateOf(false) }
            val numbers = listOf(1, 2, 3)

            // Checkbox para ver partidos de liga
            Checkbox(
                checked = verPartidosLiga.value,
                onCheckedChange = { verPartidosLiga.value = it }
            )
            Text(
                text = stringResource(id = R.string.partidos_liga),
                modifier = Modifier.padding(start = 8.dp)
            )

            // Checkbox para ver partidos amistosos
            Checkbox(
                checked = verPartidosAmistosos.value,
                onCheckedChange = { verPartidosAmistosos.value = it }
            )
            Text(
                text = stringResource(id = R.string.partidos_amistosos),
                modifier = Modifier.padding(start = 8.dp)
            )

            // Switch para ver partidos internacionales
            Switch(
                checked = verPartidosInternacionales.value,
                onCheckedChange = { verPartidosInternacionales.value = it }
            )
            Text(
                text = stringResource(id = R.string.partidos_internacionales),
                modifier = Modifier.padding(end = 8.dp)
            )

            // Dropdown Menu para número
            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
                TextField(
                    value = selectedNumber.value.toString(),
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(id = R.string.numero)) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    numbers.forEach { number ->
                        DropdownMenuItem(
                            text = { Text(text = number.toString()) },
                            onClick = {
                                selectedNumber.value = number
                                expanded = false
                            }
                        )
                    }
                }
            }

            // Botón de guardar
            Button(
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        configuracionDataStore.guardarGenero(genero.value)
                        configuracionDataStore.guardarVisibilidadPartidos(
                            verPartidosLiga.value,
                            verPartidosAmistosos.value,
                            verPartidosInternacionales.value
                        )
                        configuracionDataStore.guardarNumeroSeleccionado(selectedNumber.value)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.guardar))
            }
        }
    }
}
