package com.ignacioillanes.CurrencyExchangekotlin.Dto

import java.math.BigDecimal

data class ConvertionRequestDto (
    var from: String,
    var to: String,
    var amount: BigDecimal
)