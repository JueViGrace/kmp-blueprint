package com.jvg.sample1

import androidx.compose.ui.window.ComposeUIViewController
import com.jvg.kmpblueprint.ui.components.containers.AppContainer
import com.jvg.sample1.app.di.appModule
import com.jvg.sample1.app.presentation.ui.screen.App
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    startKoin {
        modules(appModule())
    }

    AppContainer {
        App()
    }
}
