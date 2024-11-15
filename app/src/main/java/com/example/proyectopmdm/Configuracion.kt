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
                val genero = remember { mutableStateOf("") }
                RadioButton( selected = genero.value == "Masculino",
                    onClick = { genero.value = "Masculino" } )
                Text(text = "Masculino",
                    modifier = Modifier.padding(start = 8.dp))

                RadioButton( selected =genero.value == "Femenino",
                    onClick = { genero.value = "Femenino" } )
                Text(text = "Femenino",
                    modifier = Modifier.padding(start = 8.dp))

            }
            Column(
                modifier = Modifier.fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ){
                var expanded by remember { mutableStateOf(false) }
                var selectedNumber by remember { mutableStateOf(1) }
                val numbers = listOf(1, 2, 3)
                val verPartidosLiga = remember { mutableStateOf(false) }
                val verPartidosAmistosos = remember { mutableStateOf(false) }
                Checkbox( checked = verPartidosLiga.value,
                    onCheckedChange = { verPartidosLiga.value = it } )
                Text(text = "Ver partidos de la liga",
                    modifier = Modifier.padding(start = 8.dp))

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