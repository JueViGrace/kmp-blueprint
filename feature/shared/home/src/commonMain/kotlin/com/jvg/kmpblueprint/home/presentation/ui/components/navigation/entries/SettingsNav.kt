package com.jvg.kmpblueprint.home.presentation.ui.components.navigation.entries

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jvg.kmpblueprint.ui.navigation.HomeGraph

fun NavGraphBuilder.settingsNav(
    content: @Composable () -> Unit
) {
    composable<HomeGraph.Settings> { _ ->
        content()
    }
}
