@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.proyectopmdm

import android.widget.RadioGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectopmdm.ui.theme.*

@Composable
fun Configuracion(navController: NavController) {
    ProyectoPMDMTheme {
        // Columna principal
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
                modifier = Modifier.align(CenterHorizontally),
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

            //género
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val genero = remember { mutableStateOf("") }

                // Opción "Masculino"
                RadioButton(
                    selected = genero.value == "Masculino",
                    onClick = { genero.value = "Masculino" }
                )
                Text(
                    text = stringResource(id = R.string.genero_masculino),
                    modifier = Modifier.padding(start = 8.dp)
                )

                // Opción "Femenino"
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
                modifier = Modifier.fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ){
                var expanded by remember { mutableStateOf(false) }
                var selectedNumber by remember { mutableStateOf(1) }
                val numbers = listOf(1, 2, 3)
                val verPartidosLiga = remember { mutableStateOf(false) }
                val verPartidosAmistosos = remember { mutableStateOf(false) }

                Checkbox( checked = verPartidosAmistosos.value,
                    onCheckedChange = { verPartidosAmistosos.value = it } )
                Text(text = "Ver partidos Amistosos",
                    modifier = Modifier.padding(start = 8.dp))

                    val verPartidosInternacionales = remember { mutableStateOf(false) }
                    Switch(checked = verPartidosInternacionales.value,
                        onCheckedChange = { verPartidosInternacionales.value = it })
                    Text(
                        text = "Ver partidos internacionales",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                ExposedDropdownMenuBox( expanded = expanded,
                    onExpandedChange = { expanded = !expanded } ) {
                        TextField( value = selectedNumber.toString(),
                            onValueChange = {},
                            readOnly = true,
                            label = {
                                Text("Número") },
                                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                                    colors = ExposedDropdownMenuDefaults.textFieldColors() )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false } ) {
                        numbers.forEach {
                            number ->
                            DropdownMenuItem(
                            text = { Text(text = number.toString()) },
                                onClick = {
                                    selectedNumber = number
                                    expanded = false } )
                        }
                    }
                }
            }

        }

    }
}