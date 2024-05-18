package com.garden.mobile.presentation.screen.auth.login.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState> = _state

    fun onLoginChanged(
        email: String,
        password: String,
    ) {
        _state.value = LoginState.Data(
            email,
            password,
            isLoginEnable = isValidEmail(email) && isValidPassword(password),
        )
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean =
        password.length > 5
}
