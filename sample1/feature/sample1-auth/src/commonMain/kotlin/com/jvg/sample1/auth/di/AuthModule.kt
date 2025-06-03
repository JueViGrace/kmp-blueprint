package com.jvg.sample1.auth.di

import com.jvg.kmpblueprint.auth.presentation.forgot.viewmodel.ForgotPasswordViewModel
import com.jvg.kmpblueprint.auth.presentation.signin.viewmodel.SignInViewModel
import com.jvg.sample1.auth.presentation.ui.signup.viewmodel.SignUpViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun authModule(): Module = module {
    viewModelOf(::SignInViewModel)
    viewModelOf(::SignUpViewModel)
    viewModelOf(::ForgotPasswordViewModel)
}
