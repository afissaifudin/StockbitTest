package com.afisdev.stockbittest.model

open class BaseResponse(
    val Message: String = "",
    val Type: Int? = 0,
    val HasWarning: Boolean = false
)
