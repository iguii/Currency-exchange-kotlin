package com.ignacioillanes.CurrencyExchangekotlin.Exception

import com.ignacioillanes.CurrencyExchangekotlin.Dto.ResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ConvertionExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleException(e: IllegalArgumentException): ResponseEntity<ResponseDto> {
        return ResponseEntity.badRequest().body(ResponseDto(false, null, e.message.toString()))
    }

    @ExceptionHandler(ConvertionException::class)
    fun handleException(e: ConvertionException): ResponseEntity<ResponseDto> {
        return ResponseEntity.badRequest().body(ResponseDto(false, null, e.message.toString()))
    }

    @ExceptionHandler(ServiceUnavailableException::class)
    fun handleException(e: ServiceUnavailableException): ResponseEntity<ResponseDto> {
        return ResponseEntity.status(503).body(ResponseDto(false, null, e.message.toString()))
    }
}