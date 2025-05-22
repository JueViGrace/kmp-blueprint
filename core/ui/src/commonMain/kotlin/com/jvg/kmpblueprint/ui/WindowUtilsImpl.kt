package com.jvg.kmpblueprint.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Interface that provides the screen size and orientation and any other related information if needed
interface WindowUtils {
    @Composable
    fun getScreenWidth(): Dp

    @Composable
    fun getScreenHeight(): Dp

    @Composable
    fun getScreenOrientation(): Orientation

    @Composable
    fun getScreenSize(): ScreenSize {
        val width = getScreenWidth()
        val height = getScreenHeight()

        return when (getScreenOrientation()) {
            Orientation.Portrait -> {
                when {
                    width < 600.dp ||
                        (height >= 480.dp && height < 900.dp) -> ScreenSize.Compact
                    (width >= 600.dp && width < 840.dp) ||
                        (height >= 900.dp) -> ScreenSize.Medium
                    width >= 840.dp || height > 900.dp -> ScreenSize.Large
                    else -> ScreenSize.Large
                }
            }
            Orientation.Landscape -> {
                when {
                    height < 480.dp || width <= 840.dp -> ScreenSize.Compact
                    (height >= 480.dp && height < 900.dp) ||
                        width > 840.dp -> ScreenSize.Medium
                    height >= 1200.dp || width > 840.dp -> ScreenSize.Large
                    else -> ScreenSize.Large
                }
            }
        }
    }
}

// Implementation of the WindowUtils interface
expect object WindowUtilsImpl : WindowUtils

// Composition local for the WindowUtils interface
val LocalWindowUtils: ProvidableCompositionLocal<WindowUtils> = compositionLocalOf {
    error("No WindowUtils provided")
}

enum class Orientation {
    Portrait,
    Landscape,
}

enum class ScreenSize {
    Compact,
    Medium,
    Large
}
