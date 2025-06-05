package com.jvg.sample1.auth.presentation.ui.signup.state

import com.jvg.sample1.auth.domain.rules.SignUpValidation
import com.jvg.sample1.types.auth.SignUpForm

data class SignUpState(
    val signUpForm: SignUpForm = SignUpForm(),
    val formValidation: SignUpValidation = SignUpValidation(),

    val submitLoading: Boolean = false,

    val submitError: String? = null,
    val submitEnabled: Boolean = formValidation.valid(),
)
