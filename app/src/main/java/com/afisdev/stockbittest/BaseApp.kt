package com.afisdev.stockbittest

import android.app.Application
import com.afisdev.stockbittest.module.dataSourceModule
import com.afisdev.stockbittest.module.networkModule
import com.afisdev.stockbittest.module.repositoryModule
import com.afisdev.stockbittest.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(networkModule)
            modules(dataSourceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}