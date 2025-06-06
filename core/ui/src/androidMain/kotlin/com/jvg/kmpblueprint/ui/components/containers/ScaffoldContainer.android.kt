package com.jvg.kmpblueprint.ui.components.containers

import androidx.compose.runtime.Composable

@Composable
actual fun ScaffoldContainer(
    scaffold: ScaffoldType,
    content: @Composable (() -> Unit)
) {
    ScaffoldContent(
        scaffold = scaffold,
        content = content
    )
}
