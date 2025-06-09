package com.jvg.kmpblueprint.app.presentation.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jvg.kmpblueprint.ui.components.observable.ObserveAsEvents
import com.jvg.kmpblueprint.ui.navigation.NavigationAction
import com.jvg.kmpblueprint.ui.navigation.navigator.LocalNavController
import com.jvg.kmpblueprint.ui.navigation.navigator.LocalNavigator
import com.jvg.kmpblueprint.ui.navigation.navigator.Navigator

@Composable
fun Navigation(
    performAction: (action: NavigationAction) -> Unit = { _ -> },
    routes: NavGraphBuilder.(navigator: Navigator) -> Unit,
) {
    val navigator: Navigator = LocalNavigator.current
    val navController: NavHostController = LocalNavController.current

    ObserveAsEvents(
        flow = navigator.navigationActions,
    ) { action ->
        when (action) {
            is NavigationAction.Navigate -> {
                performAction(action)
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
        routes(navigator)
    }
}
