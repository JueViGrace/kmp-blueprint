package com.jvg.sample1

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.jvg.sample1.app.di.appModule
import com.jvg.sample1.app.presentation.screen.App
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        // todo: add app module
        modules(appModule())
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "Sample App 1",
    ) {
        App()
    }
}
