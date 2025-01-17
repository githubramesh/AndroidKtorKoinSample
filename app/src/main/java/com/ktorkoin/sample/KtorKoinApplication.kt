package com.ktorkoin.sample

import android.app.Application
import com.ktorkoin.sample.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KtorKoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KtorKoinApplication)
            modules(appModule)
        }
    }
}