package com.jvg.sample1.auth.presentation.ui.signin.state

import com.jvg.sample1.auth.domain.rules.LoginValidation
import com.jvg.sample1.types.auth.LogInForm

data class SignInState(
    val logInForm: LogInForm = LogInForm(),
    val formValidation: LoginValidation = LoginValidation(),

    val shouldShowUsernameError: Boolean = false,
    val shouldShowPasswordError: Boolean = false,

    val submitLoading: Boolean = false,

    val submitError: String? = null,
    val submitEnabled: Boolean = formValidation.valid(),
)
