package com.jvg.sample1.home.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jvg.kmpblueprint.ui.components.layout.ScaffoldContainer
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.sample1.home.presentation.ui.components.layout.HomeScaffold

@Composable
fun HomeScreen() {
    val bottomNavController: NavHostController = rememberNavController()
    ScaffoldContainer(
        scaffold = { snackbarHost, content ->
            HomeScaffold(
                navController = bottomNavController,
                snackbarHost = snackbarHost,
                content = content
            )
        }
    ) {
        NavHost(
            navController = bottomNavController,
            startDestination = Destination.HomeGraph.Sample1Graph.Chats
        ) {
            composable<Destination.HomeGraph.Sample1Graph.Chats> { _ ->
            }

            composable<Destination.HomeGraph.Sample1Graph.Profile> { _ ->
            }
        }
    }
}
