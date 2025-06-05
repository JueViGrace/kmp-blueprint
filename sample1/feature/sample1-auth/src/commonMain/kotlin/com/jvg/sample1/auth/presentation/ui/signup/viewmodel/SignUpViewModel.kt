package com.jvg.sample1.auth.presentation.ui.signup.viewmodel

import androidx.lifecycle.viewModelScope
import com.jvg.kmpblueprint.auth.presentation.signup.viewmodel.SharedSignUpViewModel
import com.jvg.sample1.auth.data.AuthRepository
import com.jvg.sample1.auth.domain.rules.SignUpValidation
import com.jvg.sample1.auth.domain.rules.SignUpValidator
import com.jvg.sample1.auth.presentation.ui.signup.state.SignUpState
import com.jvg.sample1.types.auth.SignUpForm
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

class SignUpViewModel(
    override val repository: AuthRepository,
) : SharedSignUpViewModel(
    repository = repository
) {
    private val formState: MutableStateFlow<SignUpForm> = MutableStateFlow(SignUpForm())

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    private val formValidationState: StateFlow<SignUpValidation> = formState
        .debounce(1000)
        .distinctUntilChanged()
        .onEach { delay(100) }
        .flatMapLatest { value ->
            SignUpValidator.validate(value)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = SignUpValidation()
        )

    private val _state: MutableStateFlow<SignUpState> = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = combine(
        _state,
        formState,
        formValidationState,
    ) { state, formState, formValidationState ->
        state.copy(
            signUpForm = formState,
            formValidation = formValidationState
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = _state.value
    )
}
