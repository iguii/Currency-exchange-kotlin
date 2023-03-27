package com.ignacioillanes.CurrencyExchangekotlin.Api

import com.ignacioillanes.CurrencyExchangekotlin.Bl.GameConversionBl
import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionDto
import com.ignacioillanes.CurrencyExchangekotlin.Dto.ResponseDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/api/v1/currency/games")
class GameCurrrencyConversion @Autowired constructor(
    private val gameConversionBl: GameConversionBl
) {

    @GetMapping("/convert")
    fun convert(
        @RequestParam from : String,
        @RequestParam amount:BigDecimal,
        @RequestParam game:String
    ) : ResponseEntity<ResponseDto<ConvertionDto>> {
        val conversion = gameConversionBl.convert(from, amount, game)
        val response = ResponseDto(true, conversion, "Conversion successful")
        return ResponseEntity.ok(response)
    }
}