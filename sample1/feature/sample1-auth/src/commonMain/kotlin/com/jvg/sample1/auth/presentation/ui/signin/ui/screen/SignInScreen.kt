package com.jvg.sample1.auth.presentation.ui.signin.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jvg.kmpblueprint.ui.components.containers.AppContainer
import com.jvg.kmpblueprint.ui.components.containers.ScaffoldContainer
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState
import com.jvg.sample1.auth.presentation.ui.signin.ui.components.SignInContainer
import com.jvg.sample1.auth.presentation.ui.signin.viewmodel.SignInViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignInScreen(
    viewmodel: SignInViewModel = koinViewModel()
) {
    val state: SignInState by viewmodel.state.collectAsStateWithLifecycle()
    SignInContent(
        state = state,
        onEvent = viewmodel::onEvent
    )
}

@Composable
fun SignInContent(
    state: SignInState,
    onEvent: (SignInEvents) -> Unit = {}
) {
    ScaffoldContainer {
        SignInContainer(
            modifier = Modifier.fillMaxSize(),
            state = state,
            onEvent = onEvent
        )
    }
}

@Composable
@Preview
fun SignInPreview() {
    AppContainer {
        SignInContent(
            state = SignInState()
        )
    }
}
