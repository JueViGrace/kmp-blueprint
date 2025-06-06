package com.jvg.kmpblueprint.auth.presentation.signin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.navOptions
import com.jvg.kmpblueprint.auth.data.SharedAuthRepository
import com.jvg.kmpblueprint.shared.presentation.viewmodel.BaseViewModel
import com.jvg.kmpblueprint.ui.navigation.AuthGraph
import kotlinx.coroutines.CoroutineScope

abstract class SharedSignInViewModel(
    protected open val repository: SharedAuthRepository,
) : BaseViewModel, ViewModel() {
    override val scope: CoroutineScope = viewModelScope

    fun navigateToForgotPassword() {
        navigateTo(
            destination = AuthGraph.ForgotPassword,
            navOptions = navOptions {
                popUpTo(AuthGraph.SignIn) {
                    inclusive = false
                }
                launchSingleTop = true
            }
        )
    }

    fun navigateToSignUp() {
        navigateTo(
            destination = AuthGraph.SignUp,
            navOptions = navOptions {
                popUpTo(AuthGraph.SignIn) {
                    inclusive = false
                }
                launchSingleTop = true
            }
        )
    }
}
