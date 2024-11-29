package com.example.proyectopmdm.jugadores

class JugadoresRepository {
    private val jugadoresService = RetrofiInstance.jugadoresService

    suspend fun getJugadores(): List<Jugadores> {
        return jugadoresService.getJugadores()
    }
}