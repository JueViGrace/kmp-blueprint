package com.jvg.sample1.auth.presentation.ui.signin.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jvg.kmpblueprint.auth.presentation.components.GoToSignInCard
import com.jvg.kmpblueprint.ui.components.containers.lazy.VerticalLazyLayout
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState

@Composable
fun SignInContainer(
    modifier: Modifier = Modifier,
    state: SignInState,
    onEvent: (SignInEvents) -> Unit
) {
    VerticalLazyLayout(
        modifier = modifier,
        content = {
            item {
                SignInMainSection(
                    modifier = Modifier.fillMaxSize(),
                    state = state,
                    onEvent = onEvent,
                )
            }

            item {
                GoToSignInCard(
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
                    onClick = {
                        onEvent(SignInEvents.OnSignUp)
                    }
                )
            }
        },
        mediumContent = {
            item {
                SignInLandscapeLayout(
                    modifier = Modifier.fillParentMaxSize(),
                    state = state,
                    onEvent = onEvent
                )
            }
        },
    )
}
