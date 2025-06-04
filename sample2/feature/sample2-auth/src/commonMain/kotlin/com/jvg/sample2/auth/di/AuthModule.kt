package com.jvg.sample2.auth.di

import com.jvg.sample2.auth.data.AuthRepository
import com.jvg.sample2.auth.data.DefaultAuthRepository
import com.jvg.sample2.auth.presentation.ui.forgot.viewmodel.ForgotPasswordViewModel
import com.jvg.sample2.auth.presentation.ui.signin.viewmodel.SignInViewModel
import com.jvg.sample2.auth.presentation.ui.signup.viewmodel.SignUpViewModel
import com.jvg.sample2.database.auth.AuthHelper
import com.jvg.sample2.database.auth.DefaultAuthHelper
import com.jvg.sample2.network.auth.AuthClient
import com.jvg.sample2.network.auth.DefaultAuthClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun authModule(): Module = module {
    singleOf(::DefaultAuthHelper) bind AuthHelper::class

    singleOf(::DefaultAuthClient) bind AuthClient::class

    singleOf(::DefaultAuthRepository) bind AuthRepository::class

    viewModelOf(::SignInViewModel)
    viewModelOf(::SignUpViewModel)
    viewModelOf(::ForgotPasswordViewModel)
}
