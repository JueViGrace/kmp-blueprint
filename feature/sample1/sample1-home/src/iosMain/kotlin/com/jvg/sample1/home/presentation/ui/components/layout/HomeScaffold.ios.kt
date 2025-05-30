package com.jvg.sample1.home.presentation.ui.components.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.jvg.kmpblueprint.ui.Fonts
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import com.jvg.kmpblueprint.ui.components.layout.MobileScaffold
import com.jvg.kmpblueprint.ui.components.layout.bars.top.TopBarComponent
import com.jvg.kmpblueprint.ui.navigation.tab.Sample1Tabs
import com.jvg.kmpblueprint.ui.navigation.tab.Tab
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun HomeScaffold(
    snackbarHost: @Composable (() -> Unit),
    content: @Composable ((PaddingValues) -> Unit)
) {
    val tabs: List<Tab> by remember {
        mutableStateOf(
            listOf(
                Sample1Tabs.Chats,
                Sample1Tabs.Profile
            )
        )
    }

    MobileScaffold(
        tabs = tabs,
        topBar = { currentTab ->
            when (currentTab) {
                Sample1Tabs.Chats -> {
                    TopBarComponent(
                        title = {
                            TextComponent(
                                text = stringResource(currentTab.title),
                                style = Fonts.extraLargeTextStyle,
                            )
                        }
                    )
                }

                Sample1Tabs.Profile -> {
                    TopBarComponent(
                        title = {
                            TextComponent(
                                text = stringResource(currentTab.title),
                                style = Fonts.extraLargeTextStyle,
                            )
                        }
                    )
                }

                else -> {
                    error("Invalid tab entry")
                }
            }
        },
        snackbarHost = snackbarHost,
        content = content
    )
}