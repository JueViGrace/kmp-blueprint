package com.jvg.sample2.home.presentation.viewmodel

import com.jvg.kmpblueprint.home.presentation.viewmodel.SharedHomeViewModel
import com.jvg.sample2.home.data.HomeRepository

class HomeViewModel(
    private val repository: HomeRepository
) : SharedHomeViewModel() {

}
