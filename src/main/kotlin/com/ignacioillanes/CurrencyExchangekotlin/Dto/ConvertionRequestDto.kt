package com.ignacioillanes.CurrencyExchangekotlin.Dto

import java.math.BigDecimal

class ConvertionRequestDto {
    private var from: String? = null
    private var to: String? = null
    private var amount: BigDecimal? = null
}