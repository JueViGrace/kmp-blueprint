package com.jvg.kmpblueprint.auth.presentation.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jvg.kmpblueprint.shared.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope

class SignUpViewModel : BaseViewModel, ViewModel() {
    override val scope: CoroutineScope = viewModelScope
}
