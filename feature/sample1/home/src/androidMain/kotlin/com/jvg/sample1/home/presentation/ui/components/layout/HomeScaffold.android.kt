package com.jvg.sample1.home.presentation.ui.components.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import com.jvg.kmpblueprint.ui.components.layout.bars.top.TopBarComponent
import com.jvg.kmpblueprint.ui.navigation.LocalNavigator
import com.jvg.kmpblueprint.ui.navigation.Navigator
import com.jvg.sample1.home.presentation.ui.components.layout.bar.BottomBarComponent
import com.jvg.sample1.home.presentation.ui.model.BottomDestinations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun HomeScaffold(
    navController: NavHostController,
    snackbarHost: @Composable (() -> Unit),
    content: @Composable ((PaddingValues) -> Unit)
) {
    val navigator: Navigator = LocalNavigator.current
    val scope: CoroutineScope = rememberCoroutineScope()

    var currentTab: BottomDestinations by remember {
        mutableStateOf(BottomDestinations.Chats)
    }

    Scaffold(
        topBar = {
            when (currentTab) {
                BottomDestinations.Chats -> {
                    TopBarComponent(
                        title = {
                            // todo: current selected tab
                            TextComponent(
                                text = stringResource(currentTab.title),
                            )
                        }
                    )
                }

                BottomDestinations.Profile -> {
                    TopBarComponent(
                        title = {
                            // todo: current selected tab
                            TextComponent(
                                text = stringResource(currentTab.title),
                            )
                        }
                    )
                }
            }
        },
        bottomBar = {
            BottomBarComponent(
                navController = navController,
            ) { destination ->
                currentTab = destination
                scope.launch {
                    navigator.navigate(destination.route)
                }
            }
        },
        snackbarHost = snackbarHost,
        content = content
    )
}
