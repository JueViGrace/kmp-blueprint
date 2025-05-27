package com.jvg.sample2.app.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.jvg.kmpblueprint.app.presentation.ui.components.navigation.Navigation
import com.jvg.kmpblueprint.app.presentation.ui.screens.splash.SplashScreen
import com.jvg.kmpblueprint.resources.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.resources.generated.resources.compose_multiplatform
import com.jvg.kmpblueprint.ui.components.layout.ScaffoldContainer
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.sample2.app.presentation.ui.components.layout.AppScaffold
import com.jvg.sample2.auth.presentation.ui.components.navigation.graph.authGraph
import com.jvg.sample2.home.presentation.ui.components.navigation.graph.homeGraph
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    ScaffoldContainer(
        scaffold = { snackbarHost, content ->
            AppScaffold(
                snackbarHost = snackbarHost,
                content = content
            )
        }
    ) {
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
}
