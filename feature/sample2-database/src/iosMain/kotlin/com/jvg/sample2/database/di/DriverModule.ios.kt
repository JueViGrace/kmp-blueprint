package com.jvg.sample2.database.di

import com.jvg.kmpblueprint.database.driver.DriverFactory
import com.jvg.kmpblueprint.database.driver.DriverFactoryImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/*
* Database driver dependency injection module for Ios target.
* */
actual fun driverModule(): Module = module {
    singleOf(::DriverFactoryImpl) bind DriverFactory::class
}
