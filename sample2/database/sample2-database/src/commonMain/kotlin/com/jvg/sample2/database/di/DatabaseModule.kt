package com.jvg.sample2.database.di

import com.jvg.kmpblueprint.database.helper.DbHelper
import com.jvg.sample2.database.helper.DbHelperImpl
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
