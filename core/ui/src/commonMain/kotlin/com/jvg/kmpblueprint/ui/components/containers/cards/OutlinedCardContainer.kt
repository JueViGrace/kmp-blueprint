package com.jvg.kmpblueprint.ui.components.containers.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun OutlinedCardContainer(
    modifier: Modifier = Modifier,
    colors: CardColors = CardDefaults.outlinedCardColors(),
    elevation: CardElevation = CardDefaults.outlinedCardElevation(),
    border: BorderStroke = CardDefaults.outlinedCardBorder(),
    shape: Shape = CardDefaults.shape,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceEvenly,
    content: @Composable () -> Unit
) {
    OutlinedCard(
        modifier = modifier,
        colors = colors,
        elevation = elevation,
        border = border,
        shape = shape,
    ) {
        Row(
            modifier = Modifier.padding(contentPadding),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingContent?.invoke()
            content()
            trailingContent?.invoke()
        }
    }
}

@Composable
fun OutlinedCardContainer(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    colors: CardColors = CardDefaults.outlinedCardColors(),
    elevation: CardElevation = CardDefaults.outlinedCardElevation(),
    border: BorderStroke = CardDefaults.outlinedCardBorder(),
    shape: Shape = CardDefaults.shape,
    interactionSource: MutableInteractionSource? = null,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceEvenly,
    content: @Composable () -> Unit
) {
    OutlinedCard(
        modifier = modifier,
        colors = colors,
        elevation = elevation,
        border = border,
        shape = shape,
        onClick = onClick,
        enabled = enabled,
        interactionSource = interactionSource,
    ) {
        Row(
            modifier = Modifier.padding(contentPadding),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingContent?.invoke()
            content()
            trailingContent?.invoke()
        }
    }
}
