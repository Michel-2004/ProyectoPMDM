@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.proyectopmdm

import ConfiguracionDataStore
import android.util.Log
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
import android.widget.Toast

@Composable
fun Configuracion(navController: NavController) {
    val context = LocalContext.current
    val configuracionDataStore = ConfiguracionDataStore(context)

    // Estados inicializados con valores predeterminados
    val generoGuardado by configuracionDataStore.genero.collectAsState(initial = "")
    val verLigaGuardado by configuracionDataStore.verPartidosLiga.collectAsState(initial = false)
    val verAmistososGuardado by configuracionDataStore.verPartidosAmistosos.collectAsState(initial = false)
    val verInternacionalesGuardado by configuracionDataStore.verPartidosInternacionales.collectAsState(initial = false)
    val numeroGuardado by configuracionDataStore.numeroSeleccionado.collectAsState(initial = 1)

    val genero = remember { mutableStateOf(generoGuardado ?: "") }
    val verPartidosLiga = remember { mutableStateOf(verLigaGuardado) }
    val verPartidosAmistosos = remember { mutableStateOf(verAmistososGuardado) }
    val verPartidosInternacionales = remember { mutableStateOf(verInternacionalesGuardado) }
    val selectedNumber = remember { mutableStateOf(numeroGuardado) }

    LaunchedEffect(generoGuardado, verLigaGuardado, verAmistososGuardado, verInternacionalesGuardado, numeroGuardado) {
        genero.value = generoGuardado ?: ""
        verPartidosLiga.value = verLigaGuardado
        verPartidosAmistosos.value = verAmistososGuardado
        verPartidosInternacionales.value = verInternacionalesGuardado
        selectedNumber.value = numeroGuardado
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.volver),
            modifier = Modifier
                .clickable { navController.popBackStack() }
                .align(Alignment.Start)
        )

        Text(
            text = stringResource(id = R.string.configuracion_titulo),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = genero.value == "Masculino",
                onClick = { genero.value = "Masculino" }
            )
            Text(text = stringResource(id = R.string.genero_masculino))

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = genero.value == "Femenino",
                onClick = { genero.value = "Femenino" }
            )
            Text(text = stringResource(id = R.string.genero_femenino))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = verPartidosLiga.value,
                onCheckedChange = { verPartidosLiga.value = it }
            )
            Text(text = stringResource(id = R.string.partidos_liga))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = verPartidosAmistosos.value,
                onCheckedChange = { verPartidosAmistosos.value = it }
            )
            Text(text = stringResource(id = R.string.partidos_amistosos))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = verPartidosInternacionales.value,
                onCheckedChange = { verPartidosInternacionales.value = it }
            )
            Text(text = stringResource(id = R.string.partidos_internacionales))
        }

        Spacer(modifier = Modifier.height(16.dp))

        var expanded by remember { mutableStateOf(false) }
        val options = (1..5).toList()

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedNumber.value.toString(),
                onValueChange = {},
                readOnly = true,
                modifier = Modifier.clickable { expanded = !expanded },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option.toString()) },
                        onClick = {
                            selectedNumber.value = option
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (genero.value.isNotEmpty()) {

                Toast.makeText(context, "Configuración guardada correctamente", Toast.LENGTH_LONG).show()
                navController.navigate("Inicio")
            } else {
                Toast.makeText(context, "Por favor, selecciona un género", Toast.LENGTH_SHORT).show()
            }

            CoroutineScope(Dispatchers.IO).launch {
                configuracionDataStore.guardarGenero(genero.value)
                configuracionDataStore.guardarVisibilidadPartidos(
                    verPartidosLiga.value,
                    verPartidosAmistosos.value,
                    verPartidosInternacionales.value
                )
                configuracionDataStore.guardarNumeroSeleccionado(selectedNumber.value)
            }
        }) {
            Text(text = stringResource(id = R.string.guardar))
        }
    }
}
