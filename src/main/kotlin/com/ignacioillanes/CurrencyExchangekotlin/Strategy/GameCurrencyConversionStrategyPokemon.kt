package com.ignacioillanes.CurrencyExchangekotlin.Strategy

import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionDto
import com.ignacioillanes.CurrencyExchangekotlin.Dto.QueryDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.util.*

class GameCurrencyConversionStrategyPokemon : GameCurrencyConversionStrategy {
    val logger: Logger = LoggerFactory.getLogger(GameCurrencyConversionStrategyPokemon::class.java)
    override fun convert(amount: BigDecimal): BigDecimal {
        logger.info("GameCurrencyConversionStrategyPokemon.convert called with params: amount=$amount")
        return amount.multiply(BigDecimal(190))
    }
}