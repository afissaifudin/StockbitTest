package com.afisdev.core.extension

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.math.roundToInt

val Double.decimalFormat:String
    get() {
        val locale = Locale("IN", "ID")
        val formatter = DecimalFormat("#,###,###.##", DecimalFormatSymbols.getInstance(locale))
        return formatter.format(this)
    }

val Double.addPositiveSymbol: String
    get() =
        when {
            this > 0 -> "+"
            else -> ""
        }

fun Double.roundingAndDecimalFormat(): String {
    return this.rounding2Digit().decimalFormat
}

fun Double.rounding2Digit():Double{
    return (this * 100.0).roundToInt() /100.0
}

fun Double.formatDataCalPercent(percent: Double?): String{
    return "${this.addPositiveSymbol}${this.roundingAndDecimalFormat()}(${percent?.addPositiveSymbol}$percent%)"
}