package com.jvg.sample1.app.di

import com.jvg.kmpblueprint.api.client.base.NetworkClient
import com.jvg.kmpblueprint.api.client.ktor.KtorClientImpl
import com.jvg.sample1.app.data.AppRepository
import com.jvg.sample1.app.data.DefaultAppRepository
import com.jvg.sample1.app.presentation.viewmodel.AppViewModel
import com.jvg.sample1.auth.di.authModule
import com.jvg.sample1.database.di.databaseModule
import com.jvg.sample1.home.di.homeModule
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

/*
* Application dependency injection module.
* */
fun appModule(): Module = module {
    single<NetworkClient> {
        KtorClientImpl(
            baseUrl = "http://192.168.0.100:5000/api"
        )
    }

    // Core modules
    includes(databaseModule())

    // Feature modules
    includes(authModule(), homeModule())

    singleOf(::DefaultAppRepository) bind AppRepository::class

    viewModelOf(::AppViewModel)
}
