package com.example.proyectopmdm.jugadores

import retrofit2.http.GET

interface JugadoresService {
    @GET("/v3/2c9d76cc-6fb0-4900-bfa6-9bee2cd63bfa")
    suspend fun getJugadores(): List<Jugadores>
}