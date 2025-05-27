package com.jvg.sample1.home.presentation.ui.components.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
actual fun HomeScaffold(
    navController: NavHostController,
    snackbarHost: @Composable (() -> Unit),
    content: @Composable ((PaddingValues) -> Unit)
) {
    Scaffold(
        snackbarHost = snackbarHost,
        content = content

    )
}