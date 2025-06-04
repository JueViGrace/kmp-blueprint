package com.jvg.sample1.auth.presentation.ui.signup.viewmodel

import com.jvg.kmpblueprint.auth.presentation.signup.viewmodel.SharedSignUpViewModel
import com.jvg.sample1.auth.data.AuthRepository

class SignUpViewModel(
    override val repository: AuthRepository
) : SharedSignUpViewModel(
    repository = repository
)
