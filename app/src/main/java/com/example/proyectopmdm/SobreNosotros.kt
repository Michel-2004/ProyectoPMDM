package com.example.proyectopmdm

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectopmdm.ui.theme.ProyectoPMDMTheme
import com.example.proyectopmdm.ui.theme.primaryLight
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SobreNosotros(navController: NavController){
    ProyectoPMDMTheme {
        val texto = stringResource(id = R.string.SobreNosotros)
        val texto2 = stringResource(id = R.string.Info)
        val scrollState = rememberScrollState()
        // Columna para organizar los elementos
        Column(

            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(color = MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Texto arriba
            Text(
                text = texto,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center,
                fontSize = 45.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.fillMaxWidth()
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "volver",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
                    .wrapContentSize(Alignment.TopEnd)
            )
            Image(
                painter = painterResource(id = R.drawable.larosaleda),
                contentDescription = "logo malaga",
            )

            //Texto por pantalla
            Text(
                text = texto2,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}