package com.jvg.sample2

import androidx.compose.ui.window.ComposeUIViewController
import com.jvg.kmpblueprint.ui.components.containers.AppContainer
import com.jvg.sample2.app.di.appModule
import com.jvg.sample2.app.presentation.ui.screen.App
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    startKoin {
        modules(appModule())
    }

    AppContainer {
        App()
    }
}
