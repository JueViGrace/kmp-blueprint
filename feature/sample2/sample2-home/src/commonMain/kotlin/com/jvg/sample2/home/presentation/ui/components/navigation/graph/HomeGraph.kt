package com.jvg.sample2.home.presentation.ui.components.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.jvg.kmpblueprint.home.presentation.ui.components.navigation.entries.homeNav
import com.jvg.kmpblueprint.home.presentation.ui.components.navigation.entries.settingsNav
import com.jvg.kmpblueprint.ui.navigation.HomeGraph
import com.jvg.sample2.home.presentation.ui.screen.HomeScreen

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
    }
}
