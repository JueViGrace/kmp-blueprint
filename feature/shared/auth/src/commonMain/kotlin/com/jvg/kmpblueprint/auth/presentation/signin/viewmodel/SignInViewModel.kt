package com.jvg.kmpblueprint.auth.presentation.signin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.navOptions
import com.jvg.kmpblueprint.shared.presentation.viewmodel.BaseViewModel
import com.jvg.kmpblueprint.ui.navigation.Destination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SignInViewModel : BaseViewModel, ViewModel() {
    override val scope: CoroutineScope = viewModelScope

    fun navigateToForgotPassword() {
        viewModelScope.launch {
            navigator.navigate(
                Destination.AuthGraph.ForgotPassword,
                navOptions = navOptions {
                    popUpTo(Destination.AuthGraph.SignIn) {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            )
        }
    }

    fun navigateToSignUp() {
        viewModelScope.launch {
            navigator.navigate(
                Destination.AuthGraph.SignUp,
                navOptions = navOptions {
                    popUpTo(Destination.AuthGraph.SignIn) {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            )
        }
    }
}
