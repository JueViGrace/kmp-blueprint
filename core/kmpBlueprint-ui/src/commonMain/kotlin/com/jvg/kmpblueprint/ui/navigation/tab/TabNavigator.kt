package com.jvg.kmpblueprint.ui.navigation.tab

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavOptions
import com.jvg.kmpblueprint.ui.navigation.ActionStack
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.kmpblueprint.ui.navigation.NavigationAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface TabNavigator {
    val navigationActions: Flow<NavigationAction>
    val stateHandle: SavedStateHandle
        get() = SavedStateHandle()
    val actions: StateFlow<ActionStack>

    suspend fun navigate(
        destination: Destination,
        navOptions: NavOptions? = null,
    )

    suspend fun navigateUp()

    fun consumeAction(action: NavigationAction)

    companion object {
        val instance: TabNavigator = TabNavigatorImpl
    }
}
