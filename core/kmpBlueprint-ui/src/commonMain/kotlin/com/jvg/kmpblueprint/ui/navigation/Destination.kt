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
}

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
    sealed interface TabGraph : HomeGraph {
        @Serializable
        data object Graph : TabGraph
    }
}

@Serializable
sealed interface Sample1Graph : Destination {
    @Serializable
    sealed interface Auth : Sample1Graph {
        // add app specific destinations for authentication
    }

    @Serializable
    sealed interface Home : Sample1Graph {
        @Serializable
        sealed interface Tab : Home {
            @Serializable
            data object Chats : Tab

            @Serializable
            data object Profile : Tab
        }

        @Serializable
        data class Chat(val chatId: String) : Sample1Graph
    }
}

@Serializable
sealed interface Sample2Graph : HomeGraph {
    @Serializable
    sealed interface Auth : Sample2Graph {
        // add app specific destinations for authentication
    }

    @Serializable
    sealed interface Home : Sample2Graph {
        @Serializable
        sealed interface Tab : Home {
            @Serializable
            data object Profile : Tab
        }
    }
}
