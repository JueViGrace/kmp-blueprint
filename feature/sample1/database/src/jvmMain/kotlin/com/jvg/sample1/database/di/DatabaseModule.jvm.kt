package com.jvg.sample1.database.di

import com.jvg.kmpblueprint.database.driver.DriverFactory
import com.jvg.kmpblueprint.database.driver.DriverFactoryImpl
import com.jvg.sample1.database.Sample1DB
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/*
* Database driver dependency injection module for JVM target.
* */
actual fun driverModule(): Module = module {
    singleOf(::DriverFactoryImpl) bind DriverFactory::class

    single<Sample1DB> {
        val driver: DriverFactory = get()
        Sample1DB(driver.createAsyncDriver(Sample1DB.Schema, "jdbc:sqlite:sample1.db"))
    }
}
