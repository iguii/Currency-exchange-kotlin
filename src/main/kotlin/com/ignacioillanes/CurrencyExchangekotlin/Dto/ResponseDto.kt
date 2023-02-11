package com.ignacioillanes.CurrencyExchangekotlin.Dto

data class ResponseDto (
    var success: Boolean,
    var data: ConvertionDto?,
    var message: String,
)