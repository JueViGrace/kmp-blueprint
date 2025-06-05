package com.jvg.sample1.auth.presentation.ui.signin.viewmodel

import androidx.lifecycle.viewModelScope
import com.jvg.kmpblueprint.auth.presentation.signin.viewmodel.SharedSignInViewModel
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
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SignInViewModel(
    override val repository: AuthRepository,
) : SharedSignInViewModel(
    repository = repository
) {
    private val formState: MutableStateFlow<LogInForm> = MutableStateFlow(LogInForm())

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    private val formValidationState: StateFlow<LoginValidation> = formState
        .debounce(1000)
        .distinctUntilChanged()
        .onEach { delay(100) }
        .flatMapLatest { value ->
            LoginValidator.validate(value)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = LoginValidation()
        )

    private val _state: MutableStateFlow<SignInState> = MutableStateFlow(SignInState())
    val state: StateFlow<SignInState> = combine(
        _state,
        formState,
        formValidationState,
    ) { state, formState, formValidationState ->
        state.copy(
            logInForm = formState,
            formValidation = formValidationState.copy(
                usernameError = if (state.shouldShowUsernameError) formValidationState.usernameError else null,
                passwordError = if (state.shouldShowPasswordError) formValidationState.passwordError else null,
            )
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
        }
    }

    private fun emailChanged(value: String) {
        formState.update { state ->
            state.copy(
                username = value
            )
        }
    }

    private fun passwordChanged(value: String) {
        formState.update { state ->
            state.copy(
                password = value
            )
        }
    }

    private fun submit() {
    }
}
