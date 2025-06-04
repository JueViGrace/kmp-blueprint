package com.jvg.sample1.auth.presentation.ui.signup.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jvg.kmpblueprint.ui.components.containers.AppContainer
import com.jvg.kmpblueprint.ui.components.containers.ScaffoldContainer
import com.jvg.sample1.auth.presentation.ui.signup.state.SignUpState
import com.jvg.sample1.auth.presentation.ui.signup.viewmodel.SignUpViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = koinViewModel()
) {
    val state: SignUpState by viewModel.state.collectAsStateWithLifecycle()
    SignUpContent(
        state = state
    )
}

@Composable
fun SignUpContent(
    state: SignUpState,
) {
    ScaffoldContainer {
    }
}

@Composable
@Preview
fun SignUpScreenPreview() {
    AppContainer {
        SignUpContent(
            state = SignUpState()
        )
    }
}

