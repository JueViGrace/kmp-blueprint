package com.jvg.kmpblueprint.ui.window

import androidx.compose.runtime.Composable

/*
* JVM platform implementation of the WindowUtils interface
* */
actual object WindowUtilsImpl : WindowUtils {
    @Composable
    actual override fun getScreenOrientation(): Orientation {
        return if (getScreenWidth() > getScreenHeight()) Orientation.Landscape else Orientation.Portrait
    }
}
