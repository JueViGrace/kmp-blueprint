package com.jvg.sample1

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jvg.kmpblueprint.ui.components.containers.AppContainer
import com.jvg.kmpblueprint.ui.messages.LocalMessages
import com.jvg.kmpblueprint.ui.messages.Messages
import com.jvg.kmpblueprint.ui.navigation.LocalNavController
import com.jvg.kmpblueprint.ui.navigation.LocalNavigator
import com.jvg.kmpblueprint.ui.navigation.Navigator
import com.jvg.kmpblueprint.ui.window.LocalWindowUtils
import com.jvg.kmpblueprint.ui.window.WindowUtils
import com.jvg.sample1.app.di.appModule
import com.jvg.sample1.app.presentation.screen.App
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(appModule())
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "Sample App 1",
    ) {
        KoinContext {
            val navController: NavHostController = rememberNavController()
            val messages: Messages = koinInject()
            val navigator: Navigator = koinInject()
            val windowUtils: WindowUtils = koinInject()
            AppContainer(
                LocalMessages provides messages,
                LocalNavController provides navController,
                LocalNavigator provides navigator,
                LocalWindowUtils provides windowUtils,
            ) {
                App()
            }
        }
    }
}
