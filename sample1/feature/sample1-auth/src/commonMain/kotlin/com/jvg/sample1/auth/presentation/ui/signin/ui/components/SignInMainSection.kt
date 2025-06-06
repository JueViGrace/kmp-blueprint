package com.jvg.sample1.auth.presentation.ui.signin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jvg.kmpblueprint.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.generated.resources.compose_multiplatform
import com.jvg.kmpblueprint.resources.generated.resources.logo
import com.jvg.kmpblueprint.ui.components.display.ImageComponent
import com.jvg.kmpblueprint.ui.window.LocalWindowUtils
import com.jvg.kmpblueprint.ui.window.ScreenSize
import com.jvg.kmpblueprint.ui.window.WindowUtils
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignInMainSection(
    modifier: Modifier = Modifier,
    state: SignInState,
    onEvent: (SignInEvents) -> Unit,
) {
    val windowUtils: WindowUtils = LocalWindowUtils.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            val sizeModifier = when (windowUtils.getScreenSize()) {
                ScreenSize.Compact -> {
                    if (windowUtils.isPortrait()) {
                        Modifier.sizeIn(
                            minWidth = 100.dp,
                            minHeight = 100.dp,
                            maxWidth = 200.dp,
                            maxHeight = 200.dp
                        )
                    } else {
                        Modifier.size(200.dp)
                    }
                }

                ScreenSize.Medium -> {
                    if (windowUtils.isPortrait()) {
                        Modifier.fillMaxWidth(0.4f)
                    } else {
                        Modifier.size(250.dp)
                    }
                }

                ScreenSize.Large -> {
                    if (windowUtils.isPortrait()) {
                        Modifier.fillMaxWidth(0.2f)
                    } else {
                        Modifier.size(300.dp)
                    }
                }
            }
            ImageComponent(
                modifier = Modifier.padding(24.dp).then(sizeModifier),
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = stringResource(Res.string.logo),
            )
        }

        LogInFormSection(
            state = state,
            onEvent = onEvent
        )
    }
}
