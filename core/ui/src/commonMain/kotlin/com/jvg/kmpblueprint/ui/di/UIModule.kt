package com.jvg.kmpblueprint.ui.di

import com.jvg.kmpblueprint.ui.messages.Messages
import com.jvg.kmpblueprint.ui.messages.MessagesImpl
import com.jvg.kmpblueprint.ui.navigation.Navigator
import com.jvg.kmpblueprint.ui.navigation.NavigatorImpl
import com.jvg.kmpblueprint.ui.window.WindowUtils
import com.jvg.kmpblueprint.ui.window.WindowUtilsImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun uiModule(): Module = module {
    single<WindowUtils> {
        WindowUtilsImpl
    }

    singleOf(::MessagesImpl) bind Messages::class

    singleOf(::NavigatorImpl) bind Navigator::class
}
