package com.jvg.sample2.home.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.jvg.kmpblueprint.ui.components.containers.ScaffoldContainer
import com.jvg.kmpblueprint.ui.components.observable.ObserveAsEvents
import com.jvg.kmpblueprint.ui.navigation.HomeGraph
import com.jvg.kmpblueprint.ui.navigation.NavigationAction
import com.jvg.kmpblueprint.ui.navigation.Sample2Graph
import com.jvg.kmpblueprint.ui.navigation.navigator.LocalTabNavigator
import com.jvg.kmpblueprint.ui.navigation.tab.TabNavigator
import com.jvg.sample2.home.presentation.ui.components.layout.HomeScaffold
import com.jvg.sample2.home.presentation.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val bottomNavController: NavHostController = rememberNavController()
    val tabNavigator: TabNavigator = LocalTabNavigator.current

    ObserveAsEvents(
        flow = tabNavigator.navigationActions
    ) { action ->
        when (action) {
            is NavigationAction.Navigate -> {
                tabNavigator.consumeAction(action)
                bottomNavController.navigate(action.destination, navOptions = action.navOptions)
            }

            NavigationAction.NavigateUp -> {
                tabNavigator.consumeAction(action)
                bottomNavController.navigateUp()
            }
        }
    }

    ScaffoldContainer(
        scaffold = { snackbarHost, content ->
            HomeScaffold(
                snackbarHost = snackbarHost,
                content = content
            )
        }
    ) {
        NavHost(
            navController = bottomNavController,
            startDestination = HomeGraph.TabGraph.Graph
        ) {
            navigation<HomeGraph.TabGraph.Graph>(
                startDestination = Sample2Graph.Home.Tab.Profile
            ) {
                composable<Sample2Graph.Home.Tab.Profile> { _ ->
                }
            }
        }
    }
}
