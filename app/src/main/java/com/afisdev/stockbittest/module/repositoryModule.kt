package com.afisdev.stockbittest.module

import com.afisdev.stockbittest.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MainRepository(get())
    }
}