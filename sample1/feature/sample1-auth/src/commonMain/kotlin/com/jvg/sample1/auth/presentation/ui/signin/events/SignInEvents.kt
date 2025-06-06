package com.jvg.sample1.auth.presentation.ui.signin.events

sealed interface SignInEvents {
    /* Input */
    data class OnEmailChanged(val email: String) : SignInEvents
    data class OnPasswordChanged(val password: String) : SignInEvents

    /* Navigation */
    data object OnForgotPassword : SignInEvents
    data object OnSignUp : SignInEvents

    /* Actions */
    data object OnSubmit : SignInEvents
    data object ClearError : SignInEvents
}
