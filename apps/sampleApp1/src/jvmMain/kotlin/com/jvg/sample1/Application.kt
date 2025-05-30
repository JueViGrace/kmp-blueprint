package com.jvg.sample1

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.jvg.kmpblueprint.app.presentation.ui.components.AppContainer
import com.jvg.sample1.app.di.appModule
import com.jvg.sample1.app.presentation.ui.screen.App
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(appModule())
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "Sample App 1",
    ) {
        AppContainer {
            App()
        }
    }
}
