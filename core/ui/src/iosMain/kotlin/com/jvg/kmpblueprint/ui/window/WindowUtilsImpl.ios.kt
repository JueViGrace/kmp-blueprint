package com.jvg.kmpblueprint.ui.window

import androidx.compose.runtime.Composable

/*
* Ios platform implementation of the WindowUtils interface
* */
actual object WindowUtilsImpl : WindowUtils {
    @Composable
    actual override fun getScreenOrientation(): Orientation {
        // todo: make actual implementation for ios
        return Orientation.Portrait
    }
}
