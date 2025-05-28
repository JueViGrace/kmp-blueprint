package com.jvg.kmpblueprint.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jvg.kmpblueprint.shared.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope

abstract class SharedHomeViewModel : BaseViewModel, ViewModel() {
    override val scope: CoroutineScope = viewModelScope
}
