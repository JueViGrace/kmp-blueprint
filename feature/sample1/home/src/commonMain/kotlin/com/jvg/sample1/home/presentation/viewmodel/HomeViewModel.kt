package com.jvg.sample1.home.presentation.viewmodel

import com.jvg.kmpblueprint.home.presentation.viewmodel.SharedHomeViewModel
import com.jvg.sample1.home.data.HomeRepository

class HomeViewModel(
    private val repository: HomeRepository
) : SharedHomeViewModel() {

}
