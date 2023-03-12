package com.ignacioillanes.CurrencyExchangekotlin.Api

import com.ignacioillanes.CurrencyExchangekotlin.Bl.ConvertionBl
import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionDto
import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionRequestDto
import com.ignacioillanes.CurrencyExchangekotlin.Dto.ResponseDto
import okhttp3.OkHttpClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/api/v1/currency")
class ConvertionApi (private val convertionBl : ConvertionBl){
    val logger : Logger = LoggerFactory.getLogger(ConvertionApi::class.java)

    @GetMapping("/convert")
    fun convert(
        @RequestParam to: String,
        @RequestParam from: String,
        @RequestParam amount: BigDecimal
    ): ResponseEntity<ResponseDto> {
        logger.info("GET /api/v1/currency/convert - from:$from to:$to amount:$amount")
        val convertion : ConvertionDto = convertionBl.makeConvertion(to, from, amount)
        val response : ResponseDto = ResponseDto(true, convertion, "Convertion made successfully")

        logger.info("200 OK")
        return ResponseEntity.ok(response)
    }
}