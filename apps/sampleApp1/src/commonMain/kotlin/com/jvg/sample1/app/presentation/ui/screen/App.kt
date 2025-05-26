package com.jvg.sample1.app.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.jvg.kmpblueprint.app.presentation.ui.screens.splash.SplashScreen
import com.jvg.kmpblueprint.resources.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.resources.generated.resources.compose_multiplatform
import com.jvg.kmpblueprint.ui.components.navigation.Navigation
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.sample1.auth.presentation.ui.components.navigation.graph.graph.authGraph
import com.jvg.sample1.home.presentation.ui.components.navigation.graph.homeGraph
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    Navigation { navigator ->
        composable<Destination.Splash> { _ ->
            LaunchedEffect(Unit) {
                delay(700)
                navigator.navigate(
                    destination = Destination.HomeGraph.Home,
                    navOptions = navOptions {
                        popUpTo(Destination.Splash) {
                            inclusive = true
                        }
                    }
                )
            }

            SplashScreen(
                painter = painterResource(Res.drawable.compose_multiplatform)
            )
        }
        authGraph()
        homeGraph()
    }
}
