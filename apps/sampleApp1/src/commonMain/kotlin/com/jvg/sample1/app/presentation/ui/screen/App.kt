package com.jvg.sample1.app.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.composable
import com.jvg.kmpblueprint.app.presentation.ui.components.navigation.Navigation
import com.jvg.kmpblueprint.app.presentation.ui.screens.splash.SplashScreen
import com.jvg.kmpblueprint.ui.navigation.AuthGraph
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.kmpblueprint.ui.navigation.NavigationAction
import com.jvg.kmpblueprint_resources.generated.resources.Res
import com.jvg.kmpblueprint_resources.generated.resources.compose_multiplatform
import com.jvg.sample1.app.presentation.viewmodel.AppViewModel
import com.jvg.sample1.auth.presentation.ui.components.navigation.graph.authGraph
import com.jvg.sample1.home.presentation.ui.components.navigation.graph.homeGraph
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    val viewModel: AppViewModel = koinViewModel()

    Navigation(
        performAction = { action ->
            if (action is NavigationAction.Navigate && action.destination is AuthGraph.SignIn) {
                viewModel.endSession()
            }
        },
    ) { navigator ->
        composable<Destination.Splash> { _ ->
            LaunchedEffect(Unit) {
                viewModel.checkSession()
            }

            SplashScreen(
                painter = painterResource(Res.drawable.compose_multiplatform)
            )
        }
        authGraph()
        homeGraph()
    }
}
