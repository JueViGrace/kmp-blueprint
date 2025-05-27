package com.jvg.sample1.home.presentation.ui.components.layout.bar

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.toRoute
import com.jvg.kmpblueprint.ui.components.display.IconComponent
import com.jvg.kmpblueprint.ui.components.display.TextComponent
import com.jvg.kmpblueprint.ui.components.layout.bars.bottom.BottomTabItem
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.sample1.home.presentation.ui.model.BottomDestinations
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun BottomBarComponent(
    navController: NavHostController,
    floatingActionButton: (@Composable () -> Unit)? = null,
    onItemClick: (BottomDestinations) -> Unit
) {
    var route: Destination? by remember {
        mutableStateOf(null)
    }

    LaunchedEffect(navController.currentBackStackEntry) {
        route = navController.currentBackStackEntry?.toRoute()
    }

    BottomAppBar(
        actions = {
            for (destination: BottomDestinations in BottomDestinations.values) {
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
                    selected = route == destination.route,
                    onClick = {
                        onItemClick(destination)
                    }
                )
            }
        },
        floatingActionButton = floatingActionButton
    )
}
