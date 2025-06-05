package com.jvg.sample2.auth.presentation.ui.signin.viewmodel

import com.jvg.kmpblueprint.auth.presentation.signin.viewmodel.SharedSignInViewModel
import com.jvg.sample2.auth.data.AuthRepository

class SignInViewModel(
    override val repository: AuthRepository,
) : SharedSignInViewModel(
    repository = repository,
)
