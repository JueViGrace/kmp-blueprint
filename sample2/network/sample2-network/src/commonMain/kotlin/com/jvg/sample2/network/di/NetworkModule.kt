package com.jvg.sample2.network.di

import com.jvg.kmpblueprint.network.client.base.NetworkClient
import com.jvg.kmpblueprint.network.client.ktor.KtorClientImpl
import org.koin.core.module.Module
import org.koin.dsl.module

fun networkModule(): Module = module {
    single<NetworkClient> {
        KtorClientImpl(
            baseUrl = "http://192.168.0.100:5001/api"
        )
    }
}
