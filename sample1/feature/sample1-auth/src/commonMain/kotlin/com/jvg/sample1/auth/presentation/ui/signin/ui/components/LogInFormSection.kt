package com.jvg.sample1.auth.presentation.ui.signin.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.jvg.kmpblueprint.auth.presentation.components.input.AuthInputField
import com.jvg.kmpblueprint.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.generated.resources.forgot_password
import com.jvg.kmpblueprint.resources.generated.resources.ic_lock
import com.jvg.kmpblueprint.resources.generated.resources.ic_user
import com.jvg.kmpblueprint.resources.generated.resources.password
import com.jvg.kmpblueprint.resources.generated.resources.type_your
import com.jvg.kmpblueprint.resources.generated.resources.username
import com.jvg.kmpblueprint.resources.generated.resources.your
import com.jvg.kmpblueprint.ui.Fonts
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import com.jvg.kmpblueprint.ui.window.LocalWindowUtils
import com.jvg.kmpblueprint.ui.window.ScreenSize
import com.jvg.kmpblueprint.ui.window.WindowUtils
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LogInFormSection(
    modifier: Modifier = Modifier,
    state: SignInState,
    onEvent: (SignInEvents) -> Unit
) {
    val windowUtils: WindowUtils = LocalWindowUtils.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = stringResource(Res.string.username)

        AuthInputField(
            title = "${stringResource(Res.string.your)} $username",
            placeholder = "${stringResource(Res.string.type_your)} ${username.lowercase()}...",
            label = username,
            leadingIcon = painterResource(Res.drawable.ic_user),
            value = state.logInForm.username,
            onValueChange = { newValue ->
                onEvent(SignInEvents.OnEmailChanged(newValue))
            },
            isError = state.formValidation.usernameError != null,
            errorText = state.formValidation.usernameError?.let { stringResource(it) },
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val password = stringResource(Res.string.password)
            AuthInputField(
                title = "${stringResource(Res.string.your)} $password",
                placeholder = "${stringResource(Res.string.type_your)} ${password.lowercase()}...",
                label = password,
                leadingIcon = painterResource(Res.drawable.ic_lock),
                value = state.logInForm.password,
                onValueChange = { newValue ->
                    onEvent(SignInEvents.OnPasswordChanged(newValue))
                },
                isError = state.formValidation.passwordError != null,
                errorText = state.formValidation.passwordError?.let { stringResource(it) }
            )

            Row(
                modifier = if (windowUtils.getScreenSize() == ScreenSize.Compact) {
                    Modifier.fillMaxWidth(0.8f)
                } else {
                    Modifier.width(350.dp)
                },
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TextComponent(
                    modifier = Modifier.clickable {
                        onEvent(SignInEvents.OnForgotPassword)
                    },
                    text = stringResource(Res.string.forgot_password),
                    style = Fonts.labelTextStyle,
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}
