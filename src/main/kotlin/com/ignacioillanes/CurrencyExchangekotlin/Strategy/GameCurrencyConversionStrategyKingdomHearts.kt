package com.ignacioillanes.CurrencyExchangekotlin.Strategy

import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionDto
import com.ignacioillanes.CurrencyExchangekotlin.Dto.QueryDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.util.*

class GameCurrencyConversionStrategyKingdomHearts : GameCurrencyConversionStrategy {
    val logger : Logger = LoggerFactory.getLogger(GameCurrencyConversionStrategyKingdomHearts::class.java)
    override fun convert(amount: BigDecimal): BigDecimal {
        logger.info("GameCurrencyConversionStrategyKingdomHearts.convert called with params: amount=$amount")
        return amount.multiply(BigDecimal(63))
    }
}
