package com.jvg.sample1.auth.presentation.ui.signin.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.navigation.navOptions
import com.jvg.kmpblueprint.auth.presentation.signin.viewmodel.SharedSignInViewModel
import com.jvg.kmpblueprint.types.state.RequestState
import com.jvg.kmpblueprint.ui.navigation.AuthGraph
import com.jvg.kmpblueprint.ui.navigation.HomeGraph
import com.jvg.sample1.auth.data.AuthRepository
import com.jvg.sample1.auth.domain.rules.LoginValidation
import com.jvg.sample1.auth.domain.rules.LoginValidator
import com.jvg.sample1.auth.presentation.ui.signin.events.SignInEvents
import com.jvg.sample1.auth.presentation.ui.signin.state.SignInState
import com.jvg.sample1.types.auth.LogInForm
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    override val repository: AuthRepository,
) : SharedSignInViewModel(
    repository = repository
) {
    private val _state: MutableStateFlow<SignInState> = MutableStateFlow(SignInState())

    private val formState: MutableStateFlow<LogInForm> = MutableStateFlow(LogInForm())

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    private val formValidationState: StateFlow<LoginValidation> = formState
        .flatMapLatest { value ->
            LoginValidator.validate(value)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = LoginValidation()
        )

    val state: StateFlow<SignInState> = combine(
        _state,
        formState,
        formValidationState,
    ) { state, formState, formValidationState ->
        state.copy(
            logInForm = formState,
            formValidation = formValidationState.copy(
                usernameError = if (formState.shouldShowUsernameError) formValidationState.usernameError else null,
                passwordError = if (formState.shouldShowPasswordError) formValidationState.passwordError else null,
            ),
            submitEnabled = (!state.submitLoading && formValidationState.valid()) &&
                    (formState.username.isNotBlank() && formState.password.isNotBlank()),
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = _state.value
    )

    fun onEvent(event: SignInEvents) {
        when (event) {
            is SignInEvents.OnEmailChanged -> emailChanged(event.email)
            SignInEvents.OnForgotPassword -> navigateToForgotPassword()
            is SignInEvents.OnPasswordChanged -> passwordChanged(event.password)
            SignInEvents.OnSignUp -> navigateToSignUp()
            SignInEvents.OnSubmit -> submit()
            SignInEvents.ClearError -> clearError()
        }
    }

    private fun clearError() {
        viewModelScope.launch {
            delay(5000)
            _state.update { state ->
                state.copy(
                    submitError = null
                )
            }
        }
    }

    private fun emailChanged(value: String) {
        formState.update { state ->
            state.copy(
                username = value,
            )
        }
        viewModelScope.launch {
            delay(1000)
            formState.update { state ->
                state.copy(
                    shouldShowUsernameError = true
                )
            }
        }
    }

    private fun passwordChanged(value: String) {
        formState.update { state ->
            state.copy(
                password = value,
            )
        }
        viewModelScope.launch {
            delay(1000)
            formState.update { state ->
                state.copy(
                    shouldShowPasswordError = true
                )
            }
        }
    }

    private fun submit() {
        _state.update { state ->
            state.copy(
                submitLoading = true,
                submitError = null
            )
        }

        viewModelScope.launch {
            repository.login(formState.value).collect { result ->
                when (result) {
                    is RequestState.Error -> {
                        _state.update { state ->
                            state.copy(
                                submitLoading = false,
                                submitError = result.error
                            )
                        }
                    }

                    is RequestState.Success -> {
                        _state.update { state ->
                            state.copy(
                                submitLoading = false,
                                submitError = null,
                            )
                        }

                        navigateTo(
                            destination = HomeGraph.Graph,
                            navOptions = navOptions {
                                popUpTo(AuthGraph.Graph) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        )
                    }

                    else -> {
                        _state.update { state ->
                            state.copy(
                                submitLoading = true,
                                submitError = null,
                            )
                        }
                    }
                }
            }
        }
    }
}
