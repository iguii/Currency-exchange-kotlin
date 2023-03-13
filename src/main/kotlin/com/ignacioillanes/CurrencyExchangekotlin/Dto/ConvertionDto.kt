package com.ignacioillanes.CurrencyExchangekotlin.Dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal
import java.util.Date

@JsonIgnoreProperties(ignoreUnknown = true)
data class ConvertionDto (
    var query: QueryDto,
    var result: BigDecimal,
    var date: Date
)