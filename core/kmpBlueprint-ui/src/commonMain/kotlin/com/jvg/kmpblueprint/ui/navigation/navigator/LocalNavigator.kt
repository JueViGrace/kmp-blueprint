package com.jvg.kmpblueprint.ui.navigation.navigator

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import com.jvg.kmpblueprint.ui.navigation.tab.TabNavigator

val LocalNavigator: ProvidableCompositionLocal<Navigator> = compositionLocalOf {
    error("No Navigator found!")
}

val LocalTabNavigator: ProvidableCompositionLocal<TabNavigator> = compositionLocalOf {
    error("No TabNavigator found!")
}

val LocalNavController: ProvidableCompositionLocal<NavHostController> = compositionLocalOf {
    error("No NavController found!")
}
