package com.jvg.sample2.app.di

import com.jvg.sample2.app.data.AppRepository
import com.jvg.sample2.app.data.DefaultAppRepository
import com.jvg.sample2.app.presentation.viewmodel.AppViewModel
import com.jvg.sample2.auth.di.authModule
import com.jvg.sample2.database.di.databaseModule
import com.jvg.sample2.home.di.homeModule
import com.jvg.sample2.network.di.networkModule
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

/*
* Application dependency injection module.
* */
fun appModule(): Module = module {
    // Core modules
    includes(databaseModule(), networkModule())

    // Feature modules
    includes(authModule(), homeModule())

    singleOf(::DefaultAppRepository) bind AppRepository::class

    viewModelOf(::AppViewModel)
}
