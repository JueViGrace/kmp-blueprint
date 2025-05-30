package com.jvg.kmpblueprint.app.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jvg.kmpblueprint.shared.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope

abstract class SharedAppViewModel : BaseViewModel, ViewModel() {
    override val scope: CoroutineScope = viewModelScope

    abstract fun endSession()
}
