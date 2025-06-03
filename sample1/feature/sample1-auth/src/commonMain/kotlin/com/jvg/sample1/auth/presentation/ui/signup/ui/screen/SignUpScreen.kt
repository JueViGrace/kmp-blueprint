package com.jvg.sample1.auth.presentation.ui.signup.ui.screen

import androidx.compose.runtime.Composable
import com.jvg.kmpblueprint.auth.presentation.signup.viewmodel.SharedSignUpViewModel
import com.jvg.kmpblueprint.ui.components.containers.AppContainer
import com.jvg.kmpblueprint.ui.components.layout.ScaffoldContainer
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpScreen(
    viewModel: SharedSignUpViewModel = koinViewModel()
) {
    SignUpContent()
}

@Composable
fun SignUpContent() {
    ScaffoldContainer {

    }
}

@Composable
@Preview
fun SignUpScreenPreview() {
    AppContainer {
        SignUpContent()
    }
}

