package com.jvg.kmpblueprint.ui.components.containers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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

typealias ScaffoldType = @Composable (
    snackbarHost: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) -> Unit

@Composable
expect fun ScaffoldContainer(
    scaffold: ScaffoldType = { snackbarHost, content ->
        DefaultScaffoldComponent(
            snackbarHost = snackbarHost,
            content = content
        )
    },
    content: @Composable () -> Unit
)

@Composable
internal fun ScaffoldContent(
    scaffold: ScaffoldType,
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
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center,
        ) {
            content()
        }
    }
}

@Composable
fun DefaultScaffoldComponent(
    snackbarHost: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        snackbarHost = snackbarHost,
        content = content
    )
}
