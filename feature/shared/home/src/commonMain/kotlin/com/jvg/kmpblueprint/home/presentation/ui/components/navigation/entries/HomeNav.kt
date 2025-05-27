package com.jvg.kmpblueprint.home.presentation.ui.components.navigation.entries

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jvg.kmpblueprint.ui.navigation.Destination

fun NavGraphBuilder.homeNav(
    content: @Composable () -> Unit
) {
    composable<Destination.HomeGraph.Home> { _ ->
        content()
    }
}
