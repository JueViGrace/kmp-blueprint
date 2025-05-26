package com.jvg.kmpblueprint.shared.presentation.viewmodel

import com.jvg.kmpblueprint.ui.navigation.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

interface BaseViewModel : KoinComponent {
    val scope: CoroutineScope

    val navigator: Navigator
        get() = get()

    fun navigateBack() {
        scope.launch {
            navigator.navigateUp()
        }
    }
}
