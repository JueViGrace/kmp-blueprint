package com.jvg.kmpblueprint.auth.presentation.forgot.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jvg.kmpblueprint.ui.navigation.AuthGraph

fun NavGraphBuilder.forgotPasswordNav(
    content: @Composable () -> Unit
) {
    composable<AuthGraph.ForgotPassword> { _ ->
        content()
    }
}
