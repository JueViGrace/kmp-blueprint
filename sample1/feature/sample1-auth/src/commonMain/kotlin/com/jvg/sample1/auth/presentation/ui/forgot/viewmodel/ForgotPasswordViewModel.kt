package com.jvg.sample1.auth.presentation.ui.forgot.viewmodel

import com.jvg.kmpblueprint.auth.presentation.signin.viewmodel.SharedSignInViewModel
import com.jvg.sample1.auth.data.AuthRepository

class ForgotPasswordViewModel(
    override val repository: AuthRepository,
) : SharedSignInViewModel(
    repository = repository,
)
