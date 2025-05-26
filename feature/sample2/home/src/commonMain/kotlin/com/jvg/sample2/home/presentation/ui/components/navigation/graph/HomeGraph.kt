package com.jvg.sample2.home.presentation.ui.components.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
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
        composable<Destination.HomeGraph.Sample2Graph.Profile> { _ ->
        }
    }
}
