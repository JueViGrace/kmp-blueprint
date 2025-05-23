package com.jvg.sample1.app.presentation.screen

import androidx.compose.runtime.Composable
import com.jvg.kmpblueprint.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        AppTheme {

        }
    }
}
