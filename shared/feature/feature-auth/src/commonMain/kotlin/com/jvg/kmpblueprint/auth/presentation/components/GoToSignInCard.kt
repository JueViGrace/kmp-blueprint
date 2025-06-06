package com.jvg.kmpblueprint.auth.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jvg.kmpblueprint.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.generated.resources.go_to_sign_up
import com.jvg.kmpblueprint.resources.generated.resources.ic_chevron_right
import com.jvg.kmpblueprint.resources.generated.resources.not_have_account
import com.jvg.kmpblueprint.ui.Fonts
import com.jvg.kmpblueprint.ui.components.containers.cards.ElevatedCardContainer
import com.jvg.kmpblueprint.ui.components.display.IconComponent
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun GoToSignInCard(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    title: String = stringResource(Res.string.not_have_account),
    onClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = contentAlignment
    ) {
        ElevatedCardContainer(
            onClick = onClick,
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
                text = title,
                style = Fonts.smallTextStyle,
                textAlign = TextAlign.Center
            )
        }
    }
}
