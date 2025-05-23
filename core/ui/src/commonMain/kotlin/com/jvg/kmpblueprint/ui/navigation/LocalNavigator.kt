package com.jvg.kmpblueprint.ui.navigation

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

val LocalNavigator: ProvidableCompositionLocal<Navigator> = compositionLocalOf {
    error("No Navigator found!")
}

val LocalNavController: ProvidableCompositionLocal<NavHostController> = compositionLocalOf {
    error("No NavController found!")
}