package com.jvg.kmpblueprint.auth.presentation.ui.components.navigation.entries

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jvg.kmpblueprint.ui.navigation.Destination

fun NavGraphBuilder.forgotPasswordNav() {
    composable<Destination.AuthGraph.ForgotPassword> { _ ->
    }
}
