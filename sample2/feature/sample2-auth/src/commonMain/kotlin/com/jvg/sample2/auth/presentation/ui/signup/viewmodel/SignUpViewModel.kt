package com.jvg.sample2.auth.presentation.ui.signup.viewmodel

import com.jvg.kmpblueprint.auth.presentation.signup.viewmodel.SharedSignUpViewModel
import com.jvg.sample2.auth.data.AuthRepository

class SignUpViewModel(
    override val repository: AuthRepository,
) : SharedSignUpViewModel(
    repository = repository
)
