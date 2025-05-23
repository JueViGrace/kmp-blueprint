package com.jvg.sample1.app.di

import com.jvg.kmpblueprint.api.client.ktor.KtorClient
import com.jvg.kmpblueprint.api.client.ktor.KtorClientImpl
import com.jvg.sample1.database.di.databaseModule
import org.koin.core.module.Module
import org.koin.dsl.module

/*
* Application dependency injection module.
* */
fun appModule(): Module = module {
    single<KtorClient> {
        KtorClientImpl(
            baseUrl = "http://192.168.0.100:5000/api"
        )
    }

    includes(databaseModule())
}
