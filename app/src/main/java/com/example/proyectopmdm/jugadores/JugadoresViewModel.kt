package com.example.proyectopmdm.jugadores

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class JugadoresViewModel : ViewModel() {
    private val repository = JugadoresRepository()
    private val _jugadores = MutableLiveData<List<Jugadores>>()
    val  jugadores: LiveData<List<Jugadores>> = _jugadores

    fun fetchJugadores(){
        viewModelScope.launch {
            val jugadores = repository.getJugadores()
            _jugadores.value = jugadores
        }
    }
}