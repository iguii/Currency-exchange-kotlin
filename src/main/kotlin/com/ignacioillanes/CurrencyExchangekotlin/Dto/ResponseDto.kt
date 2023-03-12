package com.ignacioillanes.CurrencyExchangekotlin.Dto

data class ResponseDto<T> (
    var success: Boolean,
    var data: T,
    var message: String,
)