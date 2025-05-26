package com.jvg.sample2.auth.presentation.ui.components.navigation.graph.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.jvg.kmpblueprint.auth.presentation.ui.components.navigation.entries.forgotPasswordNav
import com.jvg.kmpblueprint.auth.presentation.ui.components.navigation.entries.privacyPolicyNav
import com.jvg.kmpblueprint.auth.presentation.ui.components.navigation.entries.signInNav
import com.jvg.kmpblueprint.auth.presentation.ui.components.navigation.entries.signUpNav
import com.jvg.kmpblueprint.auth.presentation.ui.components.navigation.entries.termsAndConditionsNav
import com.jvg.kmpblueprint.ui.navigation.Destination

fun NavGraphBuilder.authGraph() {
    navigation<Destination.AuthGraph.Graph>(
        startDestination = Destination.AuthGraph.SignIn
    ) {
        signInNav()
        signUpNav()
        privacyPolicyNav()
        termsAndConditionsNav()
        forgotPasswordNav()

        // Add app routes
    }
}
