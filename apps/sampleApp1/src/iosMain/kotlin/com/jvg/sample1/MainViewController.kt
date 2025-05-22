package com.jvg.sample1

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    startKoin {
        // todo: add app module
    }

    App()
}
