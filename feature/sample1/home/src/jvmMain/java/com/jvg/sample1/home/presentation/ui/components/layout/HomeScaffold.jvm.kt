package com.jvg.sample1.home.presentation.ui.components.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import com.jvg.kmpblueprint.ui.components.layout.bars.top.TopBarComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun HomeScaffold(
    snackbarHost: @Composable (() -> Unit),
    content: @Composable ((PaddingValues) -> Unit)
) {
    // todo: drawer
    Scaffold(
        topBar = {
            TopBarComponent(
                title = {
                    // todo: current selected tab
                    TextComponent(
                        text = "Home",
                    )
                }
            )
        },
        snackbarHost = snackbarHost,
        content = content
    )
}
