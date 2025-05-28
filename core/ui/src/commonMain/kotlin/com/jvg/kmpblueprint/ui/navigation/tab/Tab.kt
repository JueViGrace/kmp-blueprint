package com.jvg.kmpblueprint.ui.navigation.tab

import com.jvg.kmpblueprint.resources.resources.generated.resources.Res
import com.jvg.kmpblueprint.resources.resources.generated.resources.chats
import com.jvg.kmpblueprint.resources.resources.generated.resources.ic_chat
import com.jvg.kmpblueprint.resources.resources.generated.resources.ic_user
import com.jvg.kmpblueprint.resources.resources.generated.resources.profile
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.kmpblueprint.ui.navigation.Sample1Graph
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class Tab(
    open val route: Destination,
    open val icon: DrawableResource,
    open val title: StringResource,
)

sealed class Sample1Tabs(
    override val route: Destination,
    override val icon: DrawableResource,
    override val title: StringResource,
) : Tab(
    route = route,
    icon = icon,
    title = title
) {
    data object Chats : Tab(
        route = Sample1Graph.Home.Tab.Chats,
        icon = Res.drawable.ic_chat,
        title = Res.string.chats
    )

    data object Profile : Tab(
        route = Sample1Graph.Home.Tab.Profile,
        icon = Res.drawable.ic_user,
        title = Res.string.profile
    )
}

sealed class Sample2Tabs(
    override val route: Destination,
    override val icon: DrawableResource,
    override val title: StringResource,
) : Tab(
    route = route,
    icon = icon,
    title = title
) {
    data object Profile : Tab(
        route = Sample1Graph.Home.Tab.Profile,
        icon = Res.drawable.ic_user,
        title = Res.string.profile
    )
}
