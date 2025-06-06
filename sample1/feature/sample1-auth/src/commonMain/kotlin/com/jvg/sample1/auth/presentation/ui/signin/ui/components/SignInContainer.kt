package com.jvg.sample1.auth.presentation.ui.signin.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jvg.kmpblueprint.ui.window.LocalWindowUtils
import com.jvg.kmpblueprint.ui.window.ScreenSize
import com.jvg.kmpblueprint.ui.window.WindowUtils
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState

@Composable
fun SignInContainer(
    modifier: Modifier = Modifier,
    state: SignInState,
    onEvent: (SignInEvents) -> Unit
) {
    val windowUtils: WindowUtils = LocalWindowUtils.current
    val screenSize: ScreenSize = windowUtils.getScreenSize()

    when {
        windowUtils.isLandscape() &&
            screenSize == ScreenSize.Medium ||
            screenSize == ScreenSize.Large -> {
            SignInLandscapeLayout(
                modifier = modifier,
                state = state,
                onEvent = onEvent
            )
        }

        else -> {
            SignInMainSection(
                modifier = modifier,
                state = state,
                onEvent = onEvent,
            )
        }
    }
}
