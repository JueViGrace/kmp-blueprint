package com.jvg.sample1.home.presentation.ui.components.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable

@Composable
expect fun HomeScaffold(
    snackbarHost: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
)
