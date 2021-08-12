package com.afisdev.stockbittest.data

import com.afisdev.core.network.BaseDataSource

class NetworkDataSource(private val apiEndpoint: ApiEndpoint): BaseDataSource() {

    suspend fun getTopTier(tsym: String, limit: Int) = getResult {
        apiEndpoint.fetchTopTierList(tsym, limit)
    }
}