package com.jvg.kmpblueprint.ui.components.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jvg.kmpblueprint.ui.components.observable.ObserveAsEvents
import com.jvg.kmpblueprint.ui.messages.LocalMessages
import com.jvg.kmpblueprint.ui.messages.Messages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

typealias Scaffold = @Composable (
    snackbarHost: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) -> Unit

@Composable
fun ScaffoldContainer(
    scaffold: Scaffold = { _, _ -> },
    content: @Composable () -> Unit
) {
    val messages: Messages = LocalMessages.current
    val scope: CoroutineScope = rememberCoroutineScope()
    val hostState: SnackbarHostState = remember { SnackbarHostState() }

    ObserveAsEvents(
        flow = messages.messages,
    ) { msg ->
        scope.launch {
            val message: String = if (msg.description != null) {
                "${getString(msg.message)}. ${msg.description}"
            } else {
                getString(msg.message)
            }
            hostState.showSnackbar(message = message)
        }
    }

    scaffold(
        { SnackbarHost(hostState = hostState) },
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
            contentAlignment = Alignment.Center,
        ) {
            content()
        }
    }
}
