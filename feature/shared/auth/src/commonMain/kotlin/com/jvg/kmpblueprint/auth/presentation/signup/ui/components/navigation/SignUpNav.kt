package com.jvg.kmpblueprint.auth.presentation.signup.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jvg.kmpblueprint.ui.navigation.Destination

fun NavGraphBuilder.signUpNav(
    content: @Composable () -> Unit
) {
    composable<Destination.AuthGraph.SignUp> { _ ->
        content()
    }
}
