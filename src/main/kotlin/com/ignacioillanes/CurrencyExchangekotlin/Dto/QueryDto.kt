package com.ignacioillanes.CurrencyExchangekotlin.Dto

import java.math.BigDecimal

data class QueryDto (
    var from: String,
    var to: String,
    var amount: BigDecimal
)