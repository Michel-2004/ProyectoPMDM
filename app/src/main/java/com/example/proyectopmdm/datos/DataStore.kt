package com.example.proyectopmdm.datos

import android.content.ComponentName
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

class DataStore(private val context: Context) {
    companion object{
        private val Context.dataStoree: DataStore<Preferences> by preferencesDataStore("genero")
        val USER_GENERE_KEY = stringPreferencesKey("genero")
    }
    val getGenero: Flow<String?> = context.dataStoree.data
        .map { preferences ->
            preferences[USER_GENERE_KEY] ?: "Masculino"
        }
    suspend fun saveGenero(name: String){
        context.dataStoree.edit { preferences ->
            preferences[USER_GENERE_KEY] = name
        }
    }
}