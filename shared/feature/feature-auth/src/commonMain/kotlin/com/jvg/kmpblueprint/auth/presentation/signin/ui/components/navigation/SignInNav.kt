package com.jvg.kmpblueprint.auth.presentation.signin.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jvg.kmpblueprint.ui.navigation.AuthGraph

fun NavGraphBuilder.signInNav(
    content: @Composable () -> Unit
) {
    composable<AuthGraph.SignIn> { _ ->
        content()
    }
}
