package com.ignacioillanes.CurrencyExchangekotlin.Exception

import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionDto
import com.ignacioillanes.CurrencyExchangekotlin.Dto.ResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ConvertionExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleException(e: IllegalArgumentException): ResponseEntity<ResponseDto<ConvertionDto?>> {
        return ResponseEntity.badRequest().body(ResponseDto<ConvertionDto?>(false, null, e.message.toString()))
    }

    @ExceptionHandler(ConvertionException::class)
    fun handleException(e: ConvertionException): ResponseEntity<ResponseDto<ConvertionDto?>> {
        return ResponseEntity.badRequest().body(ResponseDto<ConvertionDto?>(false, null, e.message.toString()))
    }

    @ExceptionHandler(ServiceUnavailableException::class)
    fun handleException(e: ServiceUnavailableException): ResponseEntity<ResponseDto<ConvertionDto?>> {
        return ResponseEntity.status(503).body(ResponseDto<ConvertionDto?>(false, null, e.message.toString()))
    }
}