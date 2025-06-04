package com.jvg.sample1.app.di

import com.jvg.sample1.app.data.AppRepository
import com.jvg.sample1.app.data.DefaultAppRepository
import com.jvg.sample1.app.presentation.viewmodel.AppViewModel
import com.jvg.sample1.auth.di.authModule
import com.jvg.sample1.database.di.databaseModule
import com.jvg.sample1.home.di.homeModule
import com.jvg.sample1.network.di.networkModule
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
