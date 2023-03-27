package com.ignacioillanes.CurrencyExchangekotlin.Strategy.context;

import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionDto
import com.ignacioillanes.CurrencyExchangekotlin.Strategy.GameCurrencyConversionStrategy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class GameCurrencyConversionContext {

    private lateinit var gameCurrencyConversionStrategy: GameCurrencyConversionStrategy

    fun setStrategy(gameCurrencyConversionStrategy: GameCurrencyConversionStrategy) {
        this.gameCurrencyConversionStrategy = gameCurrencyConversionStrategy
    }

    fun convert(amount: BigDecimal) : BigDecimal {
        return gameCurrencyConversionStrategy.convert(amount)
    }
}