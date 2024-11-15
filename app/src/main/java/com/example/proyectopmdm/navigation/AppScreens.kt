package com.example.proyectopmdm.navigation

sealed class AppScreens( val route: String) {
    object Inicio : AppScreens("inicio")
    object AcercaDe : AppScreens("acercade")
    object Configuracion : AppScreens("configuracion")
    object SobreNosotros : AppScreens("sobrenosotros")

}