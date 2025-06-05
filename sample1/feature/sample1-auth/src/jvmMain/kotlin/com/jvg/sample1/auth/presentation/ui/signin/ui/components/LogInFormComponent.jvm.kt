package com.jvg.sample1.auth.presentation.ui.signin.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jvg.kmpblueprint.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.generated.resources.compose_multiplatform
import com.jvg.kmpblueprint.resources.generated.resources.go_to_sign_up
import com.jvg.kmpblueprint.resources.generated.resources.ic_chevron_right
import com.jvg.kmpblueprint.resources.generated.resources.logo
import com.jvg.kmpblueprint.resources.generated.resources.not_have_account
import com.jvg.kmpblueprint.ui.Fonts
import com.jvg.kmpblueprint.ui.components.containers.cards.ElevatedCardContainer
import com.jvg.kmpblueprint.ui.components.display.IconComponent
import com.jvg.kmpblueprint.ui.components.display.ImageComponent
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import com.jvg.kmpblueprint.ui.window.LocalWindowUtils
import com.jvg.kmpblueprint.ui.window.Orientation
import com.jvg.kmpblueprint.ui.window.WindowUtils
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
actual fun SignInContainer(
    modifier: Modifier,
    state: SignInState,
    onEvent: (SignInEvents) -> Unit
) {
    val windowUtils: WindowUtils = LocalWindowUtils.current

    when (windowUtils.getScreenOrientation()) {
        Orientation.Portrait -> {
            SignInMainSection(
                modifier = modifier,
                state = state,
                onEvent = onEvent,
                header = {
                    ImageComponent(
                        modifier = Modifier.fillMaxWidth(0.6f),
                        painter = painterResource(Res.drawable.compose_multiplatform),
                        contentDescription = stringResource(Res.string.logo),
                    )
                },
                footer = {
                    ElevatedCardContainer(
                        trailingContent = {
                            IconComponent(
                                modifier = Modifier
                                    .sizeIn(
                                        minWidth = 14.dp,
                                        maxWidth = 24.dp,
                                        minHeight = 14.dp,
                                        maxHeight = 24.dp,
                                    ),
                                painter = painterResource(Res.drawable.ic_chevron_right),
                                contentDescription = stringResource(Res.string.go_to_sign_up),
                            )
                        },
                        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
                    ) {
                        TextComponent(
                            text = stringResource(Res.string.not_have_account),
                            style = Fonts.labelTextStyle,
                        )
                    }
                }
            )
        }

        Orientation.Landscape -> {
            Row(
                modifier = modifier
            ) {
                SignInMainSection(
                    modifier = modifier,
                    state = state,
                    onEvent = onEvent,
                    header = {
                        ImageComponent(
                            modifier = Modifier.fillMaxWidth(0.6f),
                            painter = painterResource(Res.drawable.compose_multiplatform),
                            contentDescription = stringResource(Res.string.logo),
                        )
                    },
                    footer = {
                    }
                )
            }
        }
    }
}
