package com.jvg.kmpblueprint.auth.presentation.signin.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jvg.kmpblueprint.ui.navigation.Destination

fun NavGraphBuilder.signInNav(
    content: @Composable () -> Unit
) {
    composable<Destination.AuthGraph.SignIn> { _ ->
        content()
    }
}
