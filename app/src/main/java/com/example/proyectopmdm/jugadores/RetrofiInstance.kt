package com.example.proyectopmdm.jugadores

object RetrofiInstance {
    private const val BASE_URL = "C:\\Users\\mvilbou1403\\Desktop\\ProyectoPMDM\\app\\src\\main\\java\\com\\example\\proyectopmdm\\jugadores\\jugadores.json"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val ClienteJugadores: ClienteJugadores by lazy {
        retrofit.create(ClienteJugadores::class)
    }
}