package com.jvg.kmpblueprint.ui.messages

import org.jetbrains.compose.resources.StringResource

data class Message(
    val message: StringResource,
    val description: String? = null
)
