package com.ignacioillanes.CurrencyExchangekotlin.Strategy

import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionDto
import java.math.BigDecimal

interface GameCurrencyConversionStrategy {
    fun convert(amount : BigDecimal) : BigDecimal
}