package com.jvg.sample1.database.di

import com.jvg.kmpblueprint.database.DbHelper
import com.jvg.sample1.database.DbHelperImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/*
* Database dependency injection module.
* */
fun databaseModule(): Module = module {
    includes(driverModule())

    singleOf(::DbHelperImpl) bind DbHelper::class
}
