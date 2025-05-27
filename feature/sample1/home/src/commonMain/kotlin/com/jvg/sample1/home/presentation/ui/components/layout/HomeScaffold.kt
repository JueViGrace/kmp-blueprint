package com.jvg.sample1.home.presentation.ui.components.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
expect fun HomeScaffold(
    navController: NavHostController,
    snackbarHost: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
)
