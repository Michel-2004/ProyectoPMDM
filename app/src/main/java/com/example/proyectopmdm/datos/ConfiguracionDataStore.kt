package com.example.proyectopmdm.datos

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Crear un DataStore específico para configuración
private val Context.configDataStore by preferencesDataStore(name = "configuracion_prefs")

class ConfiguracionDataStore(private val context: Context) {

    // Claves para las preferencias
    companion object {
        val GENERO_KEY = stringPreferencesKey("genero")
        val LIGA_KEY = booleanPreferencesKey("liga")
        val AMISTOSOS_KEY = booleanPreferencesKey("amistosos")
        val INTERNACIONALES_KEY = booleanPreferencesKey("internacionales")
        val NUMERO_KEY = intPreferencesKey("numero_seleccionado")
    }

    // Guardar género
    suspend fun guardarGenero(genero: String) {
        context.configDataStore.edit { preferences ->
            preferences[GENERO_KEY] = genero
        }
    }

    // Guardar visibilidad de partidos
    suspend fun guardarVisibilidadPartidos(liga: Boolean, amistosos: Boolean, internacionales: Boolean) {
        context.configDataStore.edit { preferences ->
            preferences[LIGA_KEY] = liga
            preferences[AMISTOSOS_KEY] = amistosos
            preferences[INTERNACIONALES_KEY] = internacionales
        }
    }

    // Guardar número seleccionado
    suspend fun guardarNumeroSeleccionado(numero: Int) {
        context.configDataStore.edit { preferences ->
            preferences[NUMERO_KEY] = numero
        }
    }

    // Recuperar género
    val genero: Flow<String?> = context.configDataStore.data.map { preferences ->
        preferences[GENERO_KEY]
    }

    // Recuperar visibilidad de partidos
    val verPartidosLiga: Flow<Boolean> = context.configDataStore.data.map { preferences ->
        preferences[LIGA_KEY] ?: false
    }

    val verPartidosAmistosos: Flow<Boolean> = context.configDataStore.data.map { preferences ->
        preferences[AMISTOSOS_KEY] ?: false
    }

    val verPartidosInternacionales: Flow<Boolean> = context.configDataStore.data.map { preferences ->
        preferences[INTERNACIONALES_KEY] ?: false
    }

    // Recuperar número seleccionado
    val numeroSeleccionado: Flow<Int> = context.configDataStore.data.map { preferences ->
        preferences[NUMERO_KEY] ?: 1
    }
}
