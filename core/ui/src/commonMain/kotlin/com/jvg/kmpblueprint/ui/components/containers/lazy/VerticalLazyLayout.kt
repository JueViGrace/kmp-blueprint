package com.jvg.kmpblueprint.ui.components.containers.lazy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jvg.kmpblueprint.ui.window.LocalWindowUtils
import com.jvg.kmpblueprint.ui.window.ScreenSize
import com.jvg.kmpblueprint.ui.window.WindowUtils

@Composable
fun VerticalLazyLayout(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.SpaceAround,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    usePortraitCompact: Boolean = true,
    content: LazyListScope.() -> Unit,
    mediumContent: LazyListScope.() -> Unit = content,
    largeContent: LazyListScope.() -> Unit = mediumContent,
) {
    val windowUtils: WindowUtils = LocalWindowUtils.current
    val isPortrait: Boolean = windowUtils.isPortrait()
    val screenSize: ScreenSize = windowUtils.getScreenSize()

    LazyColumn(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
    ) {
        when (screenSize) {
            ScreenSize.Compact -> {
                content()
            }

            ScreenSize.Medium -> {
                if (usePortraitCompact) {
                    if (isPortrait) {
                        content()
                    } else {
                        mediumContent()
                    }
                } else {
                    mediumContent()
                }
            }

            ScreenSize.Large -> {
                largeContent()
            }
        }
    }
}
