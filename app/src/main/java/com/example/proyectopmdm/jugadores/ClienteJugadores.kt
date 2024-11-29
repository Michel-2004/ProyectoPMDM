package com.example.proyectopmdm.jugadores

interface ClienteJugadores {
    @GET("jugadores")
    suspend fun getJugadores(): List<DatosJugadores>
}