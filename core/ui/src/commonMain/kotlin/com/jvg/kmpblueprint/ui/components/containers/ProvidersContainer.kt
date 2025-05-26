package com.jvg.kmpblueprint.ui.components.containers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.jvg.kmpblueprint.ui.components.observable.ObserveAsEvents
import com.jvg.kmpblueprint.ui.messages.LocalMessages
import com.jvg.kmpblueprint.ui.messages.Messages
import com.jvg.kmpblueprint.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

@Composable
fun ProvidersContainer(
    vararg values: ProvidedValue<*>,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(values = values) {
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

        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    content()

                    SnackbarHost(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        hostState = hostState,
                        snackbar = { snackBarData ->
                            Snackbar(
                                modifier = Modifier.zIndex(1f),
                                snackbarData = snackBarData,
                            )
                        }
                    )
                }
            }
        }
    }
}
