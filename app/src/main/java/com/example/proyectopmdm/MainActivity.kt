package com.example.proyectopmdm

import android.os.Bundle
import android.widget.Button
import androidx.compose.foundation.layout.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopmdm.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoPMDMTheme {
               app()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun app() {
    ProyectoPMDMTheme {
        Column(modifier = Modifier.fillMaxSize().background(primaryLight).wrapContentSize(Alignment.Center)) {
            Image(
                painter = painterResource(id = R.drawable.malaga),
                contentDescription = "logo malaga",
                )
            Row(
                modifier = Modifier.align(CenterHorizontally),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignmet = CenterHorizontally
            ){
                    ButtonInformacion()
                     ButtonAyuda()
            }
        }
    }
}

@Composable
fun ButtonInformacion(){
    Button(onClick = { }, modifier = Modifier.padding(5.dp)) {
        Text( text = "informacion")
    }
}

@Composable
fun ButtonAyuda(){
    Button(onClick = { }, modifier = Modifier.padding(5.dp)) {
        Text( text = "ayuda")
    }
}