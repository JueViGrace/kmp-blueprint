package com.jvg.kmpblueprint.shared.presentation.viewmodel

import com.jvg.kmpblueprint.ui.messages.Messages
import com.jvg.kmpblueprint.ui.navigation.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.koin.core.component.KoinComponent

interface BaseViewModel : KoinComponent {
    val scope: CoroutineScope

    val navigator: Navigator
        get() = Navigator.instance

    val messages: Messages
        get() = Messages.instance

    fun navigateBack() {
        scope.launch {
            navigator.navigateUp()
        }
    }

    fun sendMessage(message: StringResource, description: String? = null) {
        scope.launch {
            messages.sendMessage(message, description)
        }
    }
}
