package com.example.proyectopmdm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopmdm.ui.theme.ProyectoPMDMTheme
import com.example.proyectopmdm.ui.theme.backgroundLight
import com.example.proyectopmdm.ui.theme.primaryLight

@Composable
fun AcercaDe(navController: NavController) {
    ProyectoPMDMTheme {

        Column(modifier = Modifier.fillMaxSize().background(backgroundLight).wrapContentSize(Alignment.Center).padding(20.dp)) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "volver",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
                    .wrapContentSize(Alignment.TopEnd)
            )

            Text(
                modifier = Modifier.align(CenterHorizontally).padding(15.dp),
                text = "Acerca De Malaga FC",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,


            )
            Image(
                painter = painterResource(id = R.drawable.malaga),
                contentDescription = "logo malaga",
            )

            Row(
                modifier = Modifier.align(CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically

            ){
                Text(
                    text = "Agustin",
                    Modifier.padding(10.dp),
                    fontSize = 15.sp
                )
                Text(
                    text = "Miguel C",
                    fontSize = 15.sp
                )
            }

            Text(
                    modifier = Modifier.align(CenterHorizontally),
                    text = "Licencia freemium",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 10.sp
            )

        }
    }
}