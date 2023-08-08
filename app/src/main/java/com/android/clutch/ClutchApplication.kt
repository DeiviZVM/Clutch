package com.android.clutch

import android.app.Application
import com.android.clutch.di.dataModule
import com.android.clutch.di.domainModule
import com.android.clutch.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class ClutchApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@ClutchApplication)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}