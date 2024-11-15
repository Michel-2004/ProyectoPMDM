package com.example.proyectopmdm.datos


/*
import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "configuracion")

class ConfiguracionDataStore(private val context: Context) {

    companion object {
        val TEMA_OSCURO = booleanPreferencesKey("tema_oscuro")
        val IDIOMA = stringPreferencesKey("idioma")
        val NOTIFICACIONES = booleanPreferencesKey("notificaciones")
    }

    val temaOscuro: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[TEMA_OSCURO] ?: false
    }

    val idioma: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[IDIOMA] ?: "es"
    }

    val notificaciones: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[NOTIFICACIONES] ?: true
    }

    suspend fun guardarTemaOscuro(valor: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[TEMA_OSCURO] = valor
        }
    }

    suspend fun guardarIdioma(valor: String) {
        context.dataStore.edit { preferences ->
            preferences[IDIOMA] = valor
        }
    }

    suspend fun guardarNotificaciones(valor: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[NOTIFICACIONES] = valor
        }
    }
}
*/