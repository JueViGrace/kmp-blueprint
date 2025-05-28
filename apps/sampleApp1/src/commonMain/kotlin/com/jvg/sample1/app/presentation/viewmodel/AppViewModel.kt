package com.jvg.sample1.app.presentation.viewmodel

import androidx.navigation.navOptions
import com.jvg.kmpblueprint.app.presentation.viewModel.SharedAppViewModel
import com.jvg.kmpblueprint.types.auth.Session
import com.jvg.kmpblueprint.types.state.RequestState
import com.jvg.kmpblueprint.ui.navigation.AuthGraph
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.kmpblueprint.ui.navigation.HomeGraph
import com.jvg.sample1.app.data.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AppViewModel(
    private val repository: AppRepository,
) : SharedAppViewModel() {
    val session: Flow<RequestState<Session>> = repository.session

    fun checkSession() {
        scope.launch {
            session.collect { result ->
                when (result) {
                    is RequestState.Error -> {
                        navigateTo(
                            destination = AuthGraph.SignIn,
                            navOptions = navOptions {
                                popUpTo(Destination.Splash) {
                                    inclusive = true
                                }
                            }
                        )
                    }

                    is RequestState.Success -> {
                        navigateTo(
                            destination = HomeGraph.Home,
                            navOptions = navOptions {
                                popUpTo(Destination.Splash) {
                                    inclusive = true
                                }
                            }
                        )
                    }

                    else -> {}
                }
            }
        }
    }

    override fun endSession() {
        scope.launch {
            repository.endSession()
        }
    }
}
