package com.garden.mobile.presentation.screen.auth.forgot.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForgotViewModel : ViewModel() {
    private val _state = MutableLiveData<ForgotState>()
    val state: LiveData<ForgotState> = _state

    fun onForgotChanged(email: String) {
        _state.value = ForgotState.Data(
            email,
            isForgotEnable = isValidEmail(email),
        )
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
