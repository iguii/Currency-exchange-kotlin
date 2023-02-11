package com.ignacioillanes.CurrencyExchangekotlin.Api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/currency")
class ConvertionApi {
    @GetMapping("/convert")
    fun convert(): String {
        return "Hello World"
    }
}