import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Acceso a DataStore
private val Context.dataStore by preferencesDataStore(name = "configuracion_prefs")

object PreferencesKeys {
    val genero = stringPreferencesKey("genero")
    val verPartidosLiga = booleanPreferencesKey("ver_partidos_liga")
    val verPartidosAmistosos = booleanPreferencesKey("ver_partidos_amistosos")
    val verPartidosInternacionales = booleanPreferencesKey("ver_partidos_internacionales")
    val numeroSeleccionado = intPreferencesKey("numero_seleccionado")
}

class ConfiguracionDataStore(private val context: Context) {

    // Recuperar el valor de genero (String)
    val genero: Flow<String?> = context.dataStore.data
        .map { preferences -> preferences[PreferencesKeys.genero] }

    // Recuperar el valor de verPartidosLiga (Boolean)
    val verPartidosLiga: Flow<Boolean> = context.dataStore.data
        .map { preferences -> preferences[PreferencesKeys.verPartidosLiga] ?: false }

    // Recuperar el valor de verPartidosAmistosos (Boolean)
    val verPartidosAmistosos: Flow<Boolean> = context.dataStore.data
        .map { preferences -> preferences[PreferencesKeys.verPartidosAmistosos] ?: false }

    // Recuperar el valor de verPartidosInternacionales (Boolean)
    val verPartidosInternacionales: Flow<Boolean> = context.dataStore.data
        .map { preferences -> preferences[PreferencesKeys.verPartidosInternacionales] ?: false }

    // Recuperar el valor de numeroSeleccionado (Int)
    val numeroSeleccionado: Flow<Int> = context.dataStore.data
        .map { preferences -> preferences[PreferencesKeys.numeroSeleccionado] ?: 1 }

    // Guardar el valor de genero
    suspend fun guardarGenero(genero: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.genero] = genero
        }
    }

    // Guardar la visibilidad de los partidos
    suspend fun guardarVisibilidadPartidos(
        verPartidosLiga: Boolean,
        verPartidosAmistosos: Boolean,
        verPartidosInternacionales: Boolean
    ) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.verPartidosLiga] = verPartidosLiga
            preferences[PreferencesKeys.verPartidosAmistosos] = verPartidosAmistosos
            preferences[PreferencesKeys.verPartidosInternacionales] = verPartidosInternacionales
        }
    }

    // Guardar el numero seleccionado
    suspend fun guardarNumeroSeleccionado(numero: Int) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.numeroSeleccionado] = numero
        }
    }
}
