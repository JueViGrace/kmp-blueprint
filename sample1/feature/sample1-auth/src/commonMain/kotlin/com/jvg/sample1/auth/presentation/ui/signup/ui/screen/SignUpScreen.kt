package com.jvg.sample1.auth.presentation.ui.signup.ui.screen

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jvg.kmpblueprint.ui.components.containers.AppContainer
import com.jvg.kmpblueprint.ui.components.containers.ScaffoldContainer
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import com.jvg.kmpblueprint.ui.navigation.navigator.LocalNavigator
import com.jvg.sample1.auth.presentation.ui.signup.state.SignUpState
import com.jvg.sample1.auth.presentation.ui.signup.viewmodel.SignUpViewModel
import kotlinx.coroutines.launch
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
    val navigator = LocalNavigator.current
    val scope = rememberCoroutineScope()
    ScaffoldContainer {
        Button(
            onClick = {
                scope.launch {
                    navigator.navigateUp()
                }
            }
        ) {
            TextComponent(
                text = "Go back"
            )
        }
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
