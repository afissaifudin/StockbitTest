package com.afisdev.stockbittest.module

import com.afisdev.stockbittest.data.NetworkDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        NetworkDataSource(get())
    }
}