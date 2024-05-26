package com.garden.mobile.presentation.screen.auth.forgot.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.garden.mobile.domian.utils.Constants

class ForgotViewModel : ViewModel() {
    private val _state = MutableLiveData<ForgotState>()
    val state: LiveData<ForgotState> = _state

    fun onForgotChanged(email: String) {
        _state.value = ForgotState.Form(
            email,
            isForgotEnable = isValidEmail(email),
        )
    }

    fun onForgotPassword() {
        _state.value = ForgotState.Forgot
    }

    fun onDismissErrorDialog() {
        _state.value = ForgotState.Error(
            status = false,
            message = Constants.EMPTY_STRING,
        )
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
