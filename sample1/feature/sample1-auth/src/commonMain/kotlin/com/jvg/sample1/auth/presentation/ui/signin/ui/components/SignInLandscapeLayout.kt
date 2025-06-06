package com.jvg.sample1.auth.presentation.ui.signin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jvg.kmpblueprint.auth.presentation.components.GoToSignInCard
import com.jvg.kmpblueprint.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.generated.resources.go_to_sign_up
import com.jvg.kmpblueprint.resources.generated.resources.go_to_sign_up_message
import com.jvg.kmpblueprint.resources.generated.resources.new_here
import com.jvg.kmpblueprint.ui.Fonts
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignInLandscapeLayout(
    modifier: Modifier = Modifier,
    state: SignInState,
    onEvent: (SignInEvents) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SignInMainSection(
            modifier = Modifier.weight(1f),
            state = state,
            onEvent = onEvent
        )
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primaryContainer,
                                MaterialTheme.colorScheme.tertiaryContainer,
                            ),
                            start = Offset(
                                0f,
                                Float.POSITIVE_INFINITY
                            ),
                            end = Offset(
                                Float.POSITIVE_INFINITY,
                                0f
                            )
                        )
                    ),
                color = Color.Transparent
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextComponent(
                        text = stringResource(Res.string.new_here),
                        style = Fonts.extraLargeTextStyle
                    )

                    TextComponent(
                        text = stringResource(Res.string.go_to_sign_up_message),
                    )

                    GoToSignInCard(
                        title = stringResource(Res.string.go_to_sign_up)
                    ) {
                        onEvent(SignInEvents.OnSignUp)
                    }
                }
            }
        }
    }
}
