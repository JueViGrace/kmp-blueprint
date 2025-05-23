package com.jvg.kmpblueprint.ui.messages

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

val LocalMessages: ProvidableCompositionLocal<Messages> = compositionLocalOf {
    error("No Navigator found!")
}
