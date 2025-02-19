package com.example.proyectopmdm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectopmdm.AcercaDe
import com.example.proyectopmdm.Configuracion
import com.example.proyectopmdm.Inicio
import com.example.proyectopmdm.Jugadores
import com.example.proyectopmdm.SobreNosotros
import com.example.proyectopmdm.login.Login

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =AppScreens.Inicio.route ){
        composable(route = AppScreens.Inicio.route){
            Inicio(navController)
        }

        composable(route = AppScreens.Configuracion.route ){
            Configuracion(navController)
        }

        composable(route = AppScreens.AcercaDe.route){
            AcercaDe(navController)
        }
        composable(route = AppScreens.SobreNosotros.route){
            SobreNosotros(navController)
        }
        composable(route = AppScreens.Jugadores.route){
            Jugadores(navController)
        }
        composable(route = AppScreens.Login.route){
            Login(navController)
        }
    }
}