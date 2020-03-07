package com.kris.fork

import android.app.Application
import com.kris.fork.data.di.apiModule
import com.kris.fork.data.di.repositoryModule
import com.kris.fork.data.di.storeModule
import com.kris.fork.di.viewModelModule
import com.kris.fork.domain.di.interactorModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    apiModule,
                    interactorModule,
                    repositoryModule,
                    storeModule,
                    viewModelModule
                )
            )
        }
    }
}