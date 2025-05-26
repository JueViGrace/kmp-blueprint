package com.jvg.kmpblueprint.ui.di

import com.jvg.kmpblueprint.ui.messages.Messages
import com.jvg.kmpblueprint.ui.navigation.Navigator
import org.koin.core.module.Module
import org.koin.dsl.module

fun uiModule(): Module = module {
    single<Navigator> {
        Navigator.instance
    }

    single<Messages> {
        Messages.instance
    }
}
