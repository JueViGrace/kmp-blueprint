package com.jvg.sample1.home.di

import com.jvg.sample1.home.data.DefaultHomeRepository
import com.jvg.sample1.home.data.HomeRepository
import com.jvg.sample1.home.presentation.viewmodel.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun homeModule(): Module = module {
    singleOf(::DefaultHomeRepository) bind HomeRepository::class

    viewModelOf(::HomeViewModel)
}
