package com.jvg.kmpblueprint.app.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jvg.kmpblueprint.ui.components.containers.ProvidersContainer
import com.jvg.kmpblueprint.ui.messages.LocalMessages
import com.jvg.kmpblueprint.ui.messages.Messages
import com.jvg.kmpblueprint.ui.navigation.navigator.LocalNavController
import com.jvg.kmpblueprint.ui.navigation.navigator.LocalNavigator
import com.jvg.kmpblueprint.ui.navigation.navigator.LocalTabNavigator
import com.jvg.kmpblueprint.ui.navigation.navigator.Navigator
import com.jvg.kmpblueprint.ui.navigation.tab.TabNavigator
import com.jvg.kmpblueprint.ui.theme.AppTheme
import com.jvg.kmpblueprint.ui.window.LocalWindowUtils
import com.jvg.kmpblueprint.ui.window.WindowUtils

@Composable
fun AppContainer(
    navController: NavHostController = rememberNavController(),
    content: @Composable () -> Unit
) {
    ProvidersContainer(
        LocalMessages provides Messages.instance,
        LocalNavigator provides Navigator.instance,
        LocalNavController provides navController,
        LocalTabNavigator provides TabNavigator.instance,
        LocalWindowUtils provides WindowUtils.instance,
    ) {
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                content()
            }
        }
    }
}
