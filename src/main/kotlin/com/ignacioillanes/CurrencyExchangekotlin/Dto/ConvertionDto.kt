package com.ignacioillanes.CurrencyExchangekotlin.Dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ConvertionDto (
    var query: QueryDto,
    var result: BigDecimal
)