package com.garden.mobile.presentation.screen.auth.create

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _createEnable = MutableLiveData<Boolean>()
    val createEnable: LiveData<Boolean> = _createEnable

    fun onCreateChanged(
        email: String,
        password: String,
        confirmPassword: String,
    ) {
        _email.value = email
        _password.value = password
        _confirmPassword.value = confirmPassword
        _createEnable.value =
            isValidEmail(email) && isValidPassword(password) && isValidPassword(confirmPassword)
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean =
        password.length > 5
}
