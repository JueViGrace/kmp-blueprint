package com.jvg.kmpblueprint.ui.components.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.navOptions
import com.jvg.kmpblueprint.ui.components.layout.bars.bottom.BottomBarComponent
import com.jvg.kmpblueprint.ui.navigation.HomeGraph
import com.jvg.kmpblueprint.ui.navigation.navigator.LocalTabNavigator
import com.jvg.kmpblueprint.ui.navigation.tab.Tab
import com.jvg.kmpblueprint.ui.navigation.tab.TabNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileScaffold(
    tabs: List<Tab>,
    topBar: @Composable (Tab) -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    val tabNavigator: TabNavigator = LocalTabNavigator.current
    val scope: CoroutineScope = rememberCoroutineScope()

    var currentTab: Tab by remember {
        mutableStateOf(tabs.first())
    }

    Scaffold(
        topBar = {
            topBar(currentTab)
        },
        bottomBar = {
            BottomBarComponent(
                tabs = tabs,
                currentTab = currentTab,
            ) { destination ->
                currentTab = destination
                scope.launch {
                    tabNavigator.navigate(
                        destination = destination.route,
                        navOptions = navOptions {
                            popUpTo(HomeGraph.TabGraph.Graph) {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    )
                }
            }
        },
        snackbarHost = snackbarHost,
        content = content
    )
}
