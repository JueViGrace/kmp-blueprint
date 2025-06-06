package com.jvg.sample2.app.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.navigation.navOptions
import com.jvg.kmpblueprint.app.presentation.viewModel.SharedAppViewModel
import com.jvg.kmpblueprint.types.auth.Session
import com.jvg.kmpblueprint.types.state.RequestState
import com.jvg.kmpblueprint.ui.navigation.AuthGraph
import com.jvg.kmpblueprint.ui.navigation.Destination
import com.jvg.kmpblueprint.ui.navigation.HomeGraph
import com.jvg.sample2.app.data.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AppViewModel(
    private val repository: AppRepository,
) : SharedAppViewModel() {
    val session: Flow<RequestState<Session>> = repository.session

    fun checkSession() {
        viewModelScope.launch {
            session.collect { result ->
                when (result) {
                    is RequestState.Error -> {
                        navigateTo(
                            destination = AuthGraph.Graph,
                            navOptions = navOptions {
                                popUpTo(Destination.Splash) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        )
                    }

                    is RequestState.Success -> {
                        navigateTo(
                            destination = HomeGraph.Graph,
                            navOptions = navOptions {
                                popUpTo(Destination.Splash) {
                                    inclusive = true
                                }
                                launchSingleTop = true
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
