package com.afisdev.stockbittest.repository

import com.afisdev.core.repository.BaseRepository
import com.afisdev.stockbittest.data.NetworkDataSource

class MainRepository(private val networkDataSource: NetworkDataSource): BaseRepository() {

    suspend fun fetchTopTier(tsym: String, limit: Int = 20) = singleSource {
        networkDataSource.getTopTier(tsym, limit)
    }

}