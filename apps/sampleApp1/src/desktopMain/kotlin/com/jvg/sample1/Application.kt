package com.jvg.sample1

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        // todo: add app module
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "Sample App 1",
    ) {
        App()
    }
}
