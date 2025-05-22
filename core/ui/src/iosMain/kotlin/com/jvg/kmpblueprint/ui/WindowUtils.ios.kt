package com.jvg.kmpblueprint.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual object WindowUtilsImpl : WindowUtils{
    @Composable
    override fun getScreenWidth(): Dp {
        // todo: make actual implementation for ios
        return 600.dp
    }

    @Composable
    override fun getScreenHeight(): Dp {
        // todo: make actual implementation for ios
        return 600.dp
    }

    @Composable
    override fun getScreenOrientation(): Orientation {
        // todo: make actual implementation for ios
        return Orientation.Portrait
    }


}
