package com.jvg.sample1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.jvg.sample1.app.presentation.screen.App
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            navController = rememberNavController()
            KoinContext {
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
}
