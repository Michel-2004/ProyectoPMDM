package com.example.proyectopmdm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopmdm.navigation.AppNavigation
import com.example.proyectopmdm.navigation.AppScreens
import com.example.proyectopmdm.ui.theme.ProyectoPMDMTheme
import com.example.proyectopmdm.ui.theme.backgroundLight
import com.example.proyectopmdm.ui.theme.primaryLight

@Composable
fun Inicio(navController: NavController) {
    ProyectoPMDMTheme {

        Column(
            modifier = Modifier.fillMaxSize().background(primaryLight)
                .wrapContentSize(Alignment.TopCenter).padding(15.dp)
        ) {
            Text(
                modifier = Modifier.align(CenterHorizontally),
                text = "Inicio",
                fontWeight = FontWeight.Bold,
                fontSize = 45.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontFamily = FontFamily.Serif
            )
            Image(
                painter = painterResource(id = R.drawable.malaga),
                contentDescription = "logo malaga",
                Modifier.padding(15.dp).size(width = 260.dp, height = 320.dp)
            )

            Button(onClick = {navController.navigate(route = AppScreens.AcercaDe.route)})
            {
                Modifier.padding(5.dp).background(MaterialTheme.colorScheme.onPrimaryContainer)

                Text(text = "Acerca de ")

            }

            Button(onClick = {navController.navigate(route = AppScreens.Configuracion.route)})
            {
                Modifier.padding(5.dp)
                Text(text = "Configuracion ")

            }
        }
    }
}
