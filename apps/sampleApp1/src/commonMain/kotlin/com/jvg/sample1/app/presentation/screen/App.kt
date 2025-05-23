package com.jvg.sample1.app.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jvg.kmpblueprint.resources.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.resources.generated.resources.compose_multiplatform
import com.jvg.kmpblueprint.shared.presentation.ui.screens.splash.SplashScreen
import com.jvg.kmpblueprint.ui.components.navigation.Navigation
import com.jvg.kmpblueprint.ui.navigation.Destination
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    Navigation {
        navigation<Destination.Root>(
            startDestination = Destination.Splash,
        ) {
            composable<Destination.Splash> { _ ->
                SplashScreen(
                    painter = painterResource(Res.drawable.compose_multiplatform)
                )
            }
        }
    }
}
