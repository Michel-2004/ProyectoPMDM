package com.example.proyectopmdm
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.proyectopmdm.datos.ConfiguracionDataStore
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Configuracion(configuracionDataStore: ConfiguracionDataStore) {
    val scope = rememberCoroutineScope()
    val temaOscuro by configuracionDataStore.temaOscuro.collectAsState(initial = false)
    val idioma by configuracionDataStore.idioma.collectAsState(initial = "es")
    val notificaciones by configuracionDataStore.notificaciones.collectAsState(initial = true)

    var temaOscuroSeleccionado by remember { mutableStateOf(temaOscuro) }
    var idiomaSeleccionado by remember { mutableStateOf(idioma) }
    var notificacionesSeleccionadas by remember { mutableStateOf(notificaciones) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Switch para tema oscuro
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.tema_oscuro),
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = temaOscuroSeleccionado,
                onCheckedChange = { temaOscuroSeleccionado = it }
            )
        }

        // Dropdown para seleccionar idioma
        var expanded by remember { mutableStateOf(false) }
        Box {
            TextButton(onClick = { expanded = true }) {
                Text(text = idiomaSeleccionado)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listOf("es", "en").forEach { idioma ->
                    DropdownMenuItem(
                        onClick = {
                            idiomaSeleccionado = idioma
                            expanded = false
                        },
                        text = { Text(idioma) }
                    )
                }
            }
        }

        // Switch para notificaciones
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.notificaciones),
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = notificacionesSeleccionadas,
                onCheckedChange = { notificacionesSeleccionadas = it }
            )
        }

        // Botón para guardar los cambios
        Button(
            onClick = {
                scope.launch {
                    configuracionDataStore.guardarTemaOscuro(temaOscuroSeleccionado)
                    configuracionDataStore.guardarIdioma(idiomaSeleccionado)
                    configuracionDataStore.guardarNotificaciones(notificacionesSeleccionadas)
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = stringResource(id = R.string.guardar))
        }
    }
}
