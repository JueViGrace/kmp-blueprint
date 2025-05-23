package com.jvg.sample2.app.di

import com.jvg.sample2.database.di.databaseModule
import org.koin.core.module.Module
import org.koin.dsl.module

/*
* Application dependency injection module.
* */
fun appModule(): Module = module {
    includes(databaseModule())
}
