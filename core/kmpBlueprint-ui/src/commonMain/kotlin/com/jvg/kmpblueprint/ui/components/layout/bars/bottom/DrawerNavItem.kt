package com.jvg.kmpblueprint.ui.components.layout.bars.bottom

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jvg.kmpblueprint.ui.components.display.TextComponent

@Composable
fun DrawerNavItem(
    modifier: Modifier,
    title: String,
    icon: @Composable () -> Unit,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        icon = icon,
        label = { TextComponent(text = title) },
        shape = RoundedCornerShape(8.dp)
    )
}
