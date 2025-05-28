package com.jvg.sample1.home.presentation.ui.components.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.jvg.kmpblueprint.home.presentation.ui.components.navigation.entries.homeNav
import com.jvg.kmpblueprint.home.presentation.ui.components.navigation.entries.settingsNav
import com.jvg.kmpblueprint.ui.navigation.HomeGraph
import com.jvg.kmpblueprint.ui.navigation.Sample1Graph
import com.jvg.sample1.home.presentation.ui.screen.HomeScreen

/*
 * Home navigation graph
 * */
fun NavGraphBuilder.homeGraph() {
    navigation<HomeGraph.Graph>(
        startDestination = HomeGraph.Home
    ) {
        homeNav {
            HomeScreen()
        }
        settingsNav {
        }

        // Add app routes
        composable<Sample1Graph.Home.Chat> { backStackEntry ->
            val params: Sample1Graph.Home.Chat = backStackEntry.toRoute()
        }
    }
}
