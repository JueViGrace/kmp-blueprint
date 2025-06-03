package com.jvg.kmpblueprint.ui.components.layout.bars.bottom

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import com.jvg.kmpblueprint.ui.components.display.IconComponent
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import com.jvg.kmpblueprint.ui.navigation.tab.Tab
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun BottomBarComponent(
    tabs: List<Tab>,
    currentTab: Tab,
    floatingActionButton: (@Composable () -> Unit)? = null,
    onItemClick: (Tab) -> Unit
) {
    BottomAppBar(
        actions = {
            tabs.forEach { destination ->
                BottomTabItem(
                    label = {
                        TextComponent(
                            text = stringResource(destination.title),
                        )
                    },
                    icon = {
                        IconComponent(
                            painter = painterResource(destination.icon)
                        )
                    },
                    selected = destination == currentTab,
                    onClick = {
                        onItemClick(destination)
                    }
                )
            }
        },
        floatingActionButton = floatingActionButton
    )
}
