package com.jvg.kmpblueprint.ui.window

import androidx.compose.runtime.Composable

/*
* Implementation of the WindowUtils interface
* */
expect object WindowUtilsImpl : WindowUtils {
    @Composable
    override fun getScreenOrientation(): Orientation
}

