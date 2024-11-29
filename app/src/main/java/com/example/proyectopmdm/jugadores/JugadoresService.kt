package com.example.proyectopmdm.jugadores

import retrofit2.http.GET

interface JugadoresService {
    @GET("jugadores")
    suspend fun getJugadores(): List<Jugadores>
}