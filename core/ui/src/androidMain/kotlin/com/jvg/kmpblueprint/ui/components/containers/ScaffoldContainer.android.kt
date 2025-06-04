package com.jvg.kmpblueprint.ui.components.containers

import androidx.compose.runtime.Composable
import com.jvg.kmpblueprint.ui.components.navigation.BackHandlerComponent
import com.jvg.kmpblueprint.ui.navigation.navigator.LocalNavigator
import com.jvg.kmpblueprint.ui.navigation.navigator.Navigator

@Composable
actual fun ScaffoldContainer(
    scaffold: ScaffoldType,
    content: @Composable (() -> Unit)
) {
    val navigator: Navigator = LocalNavigator.current
    BackHandlerComponent(navigator = navigator)

    ScaffoldContent(
        scaffold = scaffold,
        content = content
    )
}
