package com.example.proyectopmdm.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun signInWithEmailAndPassword(email: String, passwor: String, home: ()-> Unit)
    = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, passwor)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Log.d("Proyecto","logueado")
                        home()
                    }
                    else{
                        Log.d("Proyecto","${task.result.toString()}")
                    }
                }
        }
        catch (ex:Exception){
            Log.d("Proyecto","${ex.message}")
        }
    }

    fun createInWithEmailAndPassword(email: String, passwor: String, home: ()-> Unit) {
        if (_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email,passwor)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        home()
                    }
                    else{
                        Log.d("Proyecto","${task.result.toString()}")
                    }
                    _loading.value = false
                }

        }
    }
}