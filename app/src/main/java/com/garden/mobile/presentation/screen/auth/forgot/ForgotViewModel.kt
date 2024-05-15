package com.garden.mobile.presentation.screen.auth.forgot

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForgotViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _forgotEnable = MutableLiveData<Boolean>()
    val forgotEnable: LiveData<Boolean> = _forgotEnable

    fun onForgotChanged(email: String) {
        _email.value = email
        _forgotEnable.value = isValidEmail(email)
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
