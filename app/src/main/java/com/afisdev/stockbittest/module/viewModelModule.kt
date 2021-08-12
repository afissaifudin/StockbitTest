package com.afisdev.stockbittest.module

import com.afisdev.stockbittest.viewmodel.LoginViewModel
import com.afisdev.stockbittest.viewmodel.WatchlistViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { WatchlistViewModel(get()) }
}