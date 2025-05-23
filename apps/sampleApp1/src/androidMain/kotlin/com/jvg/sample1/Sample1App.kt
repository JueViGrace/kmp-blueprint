package com.jvg.sample1

import android.app.Application
import com.jvg.sample1.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Sample1App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize dependency injection framework
        startKoin {
            androidContext(this@Sample1App)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(appModule())
        }
    }
}
