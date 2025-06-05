package com.jvg.sample1.auth.presentation.ui.signin.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState

@Composable
actual fun SignInContainer(
    modifier: Modifier,
    state: SignInState,
    onEvent: (SignInEvents) -> Unit
) {
    LogInFormSection(
        modifier = modifier,
        state = state,
        onEvent = onEvent
    )
}