package com.jvg.kmpblueprint.app.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jvg.kmpblueprint.ui.components.containers.ProvidersContainer
import com.jvg.kmpblueprint.ui.messages.LocalMessages
import com.jvg.kmpblueprint.ui.messages.Messages
import com.jvg.kmpblueprint.ui.navigation.LocalNavController
import com.jvg.kmpblueprint.ui.navigation.LocalNavigator
import com.jvg.kmpblueprint.ui.navigation.Navigator
import com.jvg.kmpblueprint.ui.window.LocalWindowUtils
import com.jvg.kmpblueprint.ui.window.WindowUtils
import org.koin.compose.KoinContext

@Composable
fun AppContainer(
    navController: NavHostController = rememberNavController(),
    content: @Composable () -> Unit
) {
    KoinContext {
        val messages: Messages = Messages.instance
        val navigator: Navigator = Navigator.instance
        val windowUtils: WindowUtils = WindowUtils.instance
        ProvidersContainer(
            LocalMessages provides messages,
            LocalNavController provides navController,
            LocalNavigator provides navigator,
            LocalWindowUtils provides windowUtils,
        ) {
            content()
        }
    }
}
