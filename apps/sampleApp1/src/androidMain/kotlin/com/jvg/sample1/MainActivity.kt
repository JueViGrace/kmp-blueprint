package com.jvg.sample1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jvg.kmpblueprint.ui.components.containers.AppContainer
import com.jvg.sample1.app.presentation.ui.screen.App

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            navController = rememberNavController()
            AppContainer(
                navController = navController
            ) {
                App()
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
    }
}
