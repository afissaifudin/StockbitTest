package com.afisdev.stockbittest.data

import com.afisdev.stockbittest.model.ToplistResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoint {
    companion object{
        const val BaseURL = "https://min-api.cryptocompare.com/data/"
    }

    @GET("top/totaltoptiervolfull")
    suspend fun fetchTopTierList(
        @Query("tsym") tsym: String,
        @Query("limit") limit: Int = 20
    ): Response<ToplistResponse>
}