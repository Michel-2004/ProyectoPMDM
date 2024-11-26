package com.example.proyectopmdm.jugadores

class JugadoresRepository {
    private val DatosJugadores = RetrofiInstance.DatosJugadores

    suspend fun getJugadores(): List<JugadoresRepository> {
        return clienteJuagdores.getJuagadores
    }
}