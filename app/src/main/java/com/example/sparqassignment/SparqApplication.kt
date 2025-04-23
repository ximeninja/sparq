package com.example.sparqassignment

import android.app.Application
import com.example.sparqassignment.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SparqApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SparqApplication)
            modules(appModule)
        }
    }
}
