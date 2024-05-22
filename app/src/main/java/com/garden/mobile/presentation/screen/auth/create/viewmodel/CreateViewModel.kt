package com.garden.mobile.presentation.screen.auth.create.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateViewModel : ViewModel() {
    private val _state = MutableLiveData<CreateState>()
    val state: LiveData<CreateState> = _state

    fun onCreateChanged(
        name: String,
        email: String,
        password: String,
        confirmPassword: String,
    ) {
        _state.value = CreateState.Data(
            name,
            email,
            password,
            confirmPassword,
            isLoginEnable =
            isValidEmail(email) && isValidPassword(password) && isValidPassword(confirmPassword),
        )
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean =
        password.length > 5
}
