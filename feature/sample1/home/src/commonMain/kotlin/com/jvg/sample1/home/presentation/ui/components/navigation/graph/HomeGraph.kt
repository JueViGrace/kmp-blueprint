package com.jvg.sample1.home.presentation.ui.components.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.jvg.kmpblueprint.home.presentation.ui.components.navigation.entries.homeNav
import com.jvg.kmpblueprint.home.presentation.ui.components.navigation.entries.settingsNav
import com.jvg.kmpblueprint.ui.navigation.Destination

/*
 * Home navigation graph
 * */
fun NavGraphBuilder.homeGraph() {
    navigation<Destination.HomeGraph.Graph>(
        startDestination = Destination.HomeGraph.Home
    ) {
        homeNav()
        settingsNav()

        // Add app routes
        composable<Destination.HomeGraph.Sample1Graph.Profile> { _ ->
        }

        composable<Destination.HomeGraph.Sample1Graph.Chat> { backStackEntry ->
            val params: Destination.HomeGraph.Sample1Graph.Chat = backStackEntry.toRoute()
        }
    }
}
