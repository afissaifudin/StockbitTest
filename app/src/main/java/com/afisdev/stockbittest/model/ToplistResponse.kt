package com.afisdev.stockbittest.model

import com.afisdev.core.extension.rounding2Digit
import com.afisdev.stockbittest.view.fragment.WatchlistFragment
import com.google.gson.annotations.SerializedName

data class ToplistResponse(
    val Data: List<Toplist>
): BaseResponse()

data class Toplist(
    val CoinInfo: CoinInfo? = null,
    val RAW: RAW? = null
)

data class CoinInfo(
    val Name: String,
    val FullName: String
)

data class RAW(
    @SerializedName(WatchlistFragment.CURRENCY) val currency: Currency
)

data class Currency(
    val PRICE: Double,
    val OPENDAY: Double
){
    fun getPriceGap() = PRICE - OPENDAY
    fun getPercent() = ((getPriceGap()/OPENDAY)*100).rounding2Digit()
}
