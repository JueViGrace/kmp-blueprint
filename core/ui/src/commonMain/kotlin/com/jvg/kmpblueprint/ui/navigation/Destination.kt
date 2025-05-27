package com.jvg.kmpblueprint.ui.navigation

import kotlinx.serialization.Serializable

/*
* Destinations used throughout the project.
* */
@Serializable
sealed interface Destination {
    @Serializable
    data object Root : Destination

    @Serializable
    data object Splash : Destination

    @Serializable
    sealed interface AuthGraph : Destination {
        @Serializable
        data object Graph : AuthGraph

        @Serializable
        data object SignUp : AuthGraph

        @Serializable
        data object SignIn : AuthGraph

        @Serializable
        data object ForgotPassword : AuthGraph

        @Serializable
        sealed interface Sample1Graph : AuthGraph {
            // add app specific destinations for authentication
        }

        @Serializable
        sealed interface Sample2Graph : AuthGraph {
            // add app specific destinations for authentication
        }
    }

    @Serializable
    sealed interface HomeGraph : Destination {
        @Serializable
        data object Graph : HomeGraph

        @Serializable
        data object Home : HomeGraph

        @Serializable
        data object Settings : HomeGraph

        @Serializable
        sealed interface Sample1Graph : HomeGraph {
            @Serializable
            data object Profile : Sample1Graph

            @Serializable
            data object Chats : Sample1Graph

            @Serializable
            data class Chat(val chatId: String) : Sample1Graph
        }

        @Serializable
        sealed interface Sample2Graph : HomeGraph {
            @Serializable
            data object Profile : Sample2Graph
        }
    }
}
