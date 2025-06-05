package com.jvg.sample1.auth.presentation.ui.signin.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState

@Composable
expect fun SignInContainer(
    modifier: Modifier = Modifier,
    state: SignInState,
    onEvent: (SignInEvents) -> Unit
)
