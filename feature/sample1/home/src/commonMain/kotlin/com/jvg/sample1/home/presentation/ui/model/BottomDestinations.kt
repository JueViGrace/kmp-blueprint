package com.jvg.sample1.home.presentation.ui.model

import com.jvg.kmpblueprint.resources.resources.generated.resources.Res.drawable
import com.jvg.kmpblueprint.resources.resources.generated.resources.Res.string
import com.jvg.kmpblueprint.resources.resources.generated.resources.chats
import com.jvg.kmpblueprint.resources.resources.generated.resources.ic_chat
import com.jvg.kmpblueprint.resources.resources.generated.resources.ic_user
import com.jvg.kmpblueprint.resources.resources.generated.resources.profile
import com.jvg.kmpblueprint.ui.navigation.Destination
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class BottomDestinations(
    val route: Destination,
    val icon: DrawableResource,
    val title: StringResource,
) {
    data object Chats : BottomDestinations(
        route = Destination.HomeGraph.Sample1Graph.Chats,
        icon = drawable.ic_chat,
        title = string.chats
    )

    data object Profile : BottomDestinations(
        route = Destination.HomeGraph.Sample1Graph.Profile,
        icon = drawable.ic_user,
        title = string.profile
    )

    companion object {
        val values: List<BottomDestinations> = listOf(
            Chats,
            Profile
        )
    }
}
