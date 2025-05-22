package com.jvg.kmpblueprint.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp

actual object WindowUtilsImpl : WindowUtils {
    @Composable
    override fun getScreenWidth(): Dp {
        val windowInfo = LocalWindowInfo.current
        val density = LocalDensity.current
        return with(density) {
            windowInfo.containerSize.width.toDp()
        }
    }

    @Composable
    override fun getScreenHeight(): Dp {
        val windowInfo = LocalWindowInfo.current
        val density = LocalDensity.current
        return with(density) {
            windowInfo.containerSize.height.toDp()
        }
    }

    @Composable
    override fun getScreenOrientation(): Orientation {
        return if (getScreenWidth() > getScreenHeight()) Orientation.Landscape else Orientation.Portrait
    }
}
