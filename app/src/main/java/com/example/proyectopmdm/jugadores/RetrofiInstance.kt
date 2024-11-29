package com.example.proyectopmdm.jugadores

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofiInstance {
    private const val BASE_URL = "https://run.mocky.io/v3/2c9d76cc-6fb0-4900-bfa6-9bee2cd63bfa"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val jugadoresService: JugadoresService by lazy {
        retrofit.create(JugadoresService::class.java)
    }
}