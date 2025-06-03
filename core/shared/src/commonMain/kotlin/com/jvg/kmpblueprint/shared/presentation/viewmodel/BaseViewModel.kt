package com.jvg.kmpblueprint.shared.presentation.viewmodel

import androidx.navigation.NavOptions
import com.jvg.kmpblueprint.ui.messages.Messages
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.kmpblueprint.ui.navigation.navigator.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource

interface BaseViewModel {
    val scope: CoroutineScope

    val navigator: Navigator
        get() = Navigator.instance

    val messages: Messages
        get() = Messages.instance

    fun navigateTo(destination: Destination, navOptions: NavOptions? = null) {
        scope.launch {
            navigator.navigate(
                destination = destination,
                navOptions = navOptions
            )
        }
    }

    fun navigateBack() {
        scope.launch {
            navigator.navigateUp()
        }
    }

    fun sendMessage(message: StringResource, description: String? = null) {
        scope.launch {
            messages.sendMessage(
                message = message,
                description = description
            )
        }
    }
}
