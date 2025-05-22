package com.jvg.kmpblueprint.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalConfiguration
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
        var orientation by rememberSaveable { mutableIntStateOf(Configuration.ORIENTATION_PORTRAIT) }
        val configuration = LocalConfiguration.current

        LaunchedEffect(configuration) {
            snapshotFlow { configuration.orientation }
                .collect { orientation = it }
        }

        return if (orientation == Configuration.ORIENTATION_LANDSCAPE) Orientation.Landscape else Orientation.Portrait
    }
}
