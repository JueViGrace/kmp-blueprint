package com.jvg.kmpblueprint.auth.presentation.forgot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jvg.kmpblueprint.shared.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope

class ForgotPasswordViewModel : BaseViewModel, ViewModel() {
    override val scope: CoroutineScope = viewModelScope
}
