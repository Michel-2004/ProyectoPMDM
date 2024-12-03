package com.example.proyectopmdm.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.proyectopmdm.R
import com.example.proyectopmdm.ui.theme.backgroundLight
@Composable
fun Login(navController: NavController) {
    val showLoginForm = rememberSaveable{
        mutableStateOf(true)
    }
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(backgroundLight)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            if (showLoginForm.value){
                Text(text = stringResource( id = R.string.iniciar))
                UserForm(
                    isCreateAcount = false
                ){
                    email, password ->
                }
            }
            else{
                Text(text = stringResource( id = R.string.registrate))
                UserForm(
                    isCreateAcount = true
                ){
                        email, password ->
                }
            }
        }
    }
}

@Composable
fun UserForm(isCreateAcount: Boolean = false, onDone: (String, String) -> Unit = {email, password ->}) {
    val email = rememberSaveable{
        mutableStateOf("")
    }
    val password = rememberSaveable{
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable{
        mutableStateOf(false)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        EmailInput(
            emailState = email
        )
        PasswordInput(
            passwordState = password,
            labeId = "Password",
            passwordVisible = passwordVisible
        )
        
    }
}

@Composable
fun PasswordInput(passwordState: MutableState<String>, labeId: String, passwordVisible: MutableState<Boolean>) {
    val visualTransformation = if (passwordVisible.value) {
        VisualTransformation.None
    }else{
        PasswordVisualTransformation()
    }
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = {passwordState.value = it},
        label = { Text(text = labeId)},
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,

        ),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (passwordState.value.isNotBlank()) {
                passwordVisibleIcon(passwordVisible)
            }
            else{
                null
            }
        }
    )
}
@Composable
fun passwordVisibleIcon(passwordVisible: MutableState<Boolean>)
{
    val image =
        if (passwordVisible.value)
            Icons.Default.VisibilityOff
        else
            Icons.Default.Visibility
            IconButton(onClick = {passwordVisible.value = !passwordVisible.value})
            {
                Icon(
                    imageVector = image,
                    contentDescription = ""
                )
            }
        }

@Composable
fun EmailInput(emailState: MutableState<String>, lableId: String = "Email") {
    InputField(
        valueState = emailState,
        lableId = lableId,
        keyboarType = KeyboardType.Email
    )
}

@Composable
fun InputField(valueState: MutableState<String>, lableId: String, keyboarType: KeyboardType, isSingleLine: Boolean = true) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {valueState.value = it },
        label = { Text(text = lableId)},
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboarType
        )
    )
}
