package com.jvg.sample1.auth.presentation.ui.signup.viewmodel

import androidx.lifecycle.viewModelScope
import com.jvg.kmpblueprint.auth.presentation.signup.viewmodel.SharedSignUpViewModel
import com.jvg.sample1.auth.data.AuthRepository
import com.jvg.sample1.auth.presentation.ui.signup.state.SignUpState
import com.jvg.sample1.types.auth.SignUpForm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

class SignUpViewModel(
    override val repository: AuthRepository,
) : SharedSignUpViewModel(
    repository = repository
) {
    private val formState: MutableStateFlow<SignUpForm> = MutableStateFlow(SignUpForm())

    private val _state: MutableStateFlow<SignUpState> = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = combine(
        _state,
        formState
    ) { state, formState ->
        state.copy(
            signUpForm = formState
        )
    }.onEach { state ->
        // todo: validate form
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = _state.value
    )
}
