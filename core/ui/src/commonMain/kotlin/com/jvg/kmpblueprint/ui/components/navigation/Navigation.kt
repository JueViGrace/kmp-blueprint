package com.jvg.kmpblueprint.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.jvg.kmpblueprint.ui.components.observable.ObserveAsEvents
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.kmpblueprint.ui.navigation.LocalNavController
import com.jvg.kmpblueprint.ui.navigation.LocalNavigator
import com.jvg.kmpblueprint.ui.navigation.NavigationAction
import com.jvg.kmpblueprint.ui.navigation.Navigator

@Composable
fun Navigation(
    routes: NavGraphBuilder.(navigator: Navigator) -> Unit,
) {
    val navigator: Navigator = LocalNavigator.current
    val navController: NavHostController = LocalNavController.current

    ObserveAsEvents(
        flow = navigator.navigationActions,
    ) { action ->
        when (action) {
            is NavigationAction.Navigate -> {
                navigator.consumeAction(action)
                navController.navigate(action.destination, navOptions = action.navOptions)
            }

            NavigationAction.NavigateUp -> {
                navigator.consumeAction(action)
                navController.navigateUp()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = navigator.startDestination,
    ) {
        navigation<Destination.Root>(
            startDestination = Destination.Splash,
        ) {
            routes(navigator)
        }
    }
}
