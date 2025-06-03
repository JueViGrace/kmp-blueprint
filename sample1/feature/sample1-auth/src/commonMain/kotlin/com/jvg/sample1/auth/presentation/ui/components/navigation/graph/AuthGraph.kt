package com.jvg.sample1.auth.presentation.ui.components.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.jvg.kmpblueprint.auth.presentation.forgot.ui.components.navigation.forgotPasswordNav
import com.jvg.kmpblueprint.auth.presentation.signin.ui.components.navigation.signInNav
import com.jvg.kmpblueprint.auth.presentation.signup.ui.components.navigation.signUpNav
import com.jvg.kmpblueprint.ui.navigation.AuthGraph
import com.jvg.sample1.auth.presentation.ui.forgot.ui.screen.ForgotPasswordScreen
import com.jvg.sample1.auth.presentation.ui.signin.ui.screen.SignInScreen
import com.jvg.sample1.auth.presentation.ui.signup.ui.screen.SignUpScreen

fun NavGraphBuilder.authGraph() {
    navigation<AuthGraph.Graph>(
        startDestination = AuthGraph.SignIn
    ) {
        signInNav {
            SignInScreen()
        }
        signUpNav {
            SignUpScreen()
        }
        forgotPasswordNav {
            ForgotPasswordScreen()
        }
    }
}
