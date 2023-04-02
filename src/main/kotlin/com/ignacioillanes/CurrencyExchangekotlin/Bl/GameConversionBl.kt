package com.ignacioillanes.CurrencyExchangekotlin.Bl

import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionDto
import com.ignacioillanes.CurrencyExchangekotlin.Dto.QueryDto
import com.ignacioillanes.CurrencyExchangekotlin.Strategy.*
import com.ignacioillanes.CurrencyExchangekotlin.Strategy.context.GameCurrencyConversionContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class GameConversionBl @Autowired constructor(
    private val convertionBl: ConvertionBl,
    private val gameCurrencyConversionContext: GameCurrencyConversionContext
) {
    val logger : Logger = LoggerFactory.getLogger(GameConversionBl::class.java)
    fun convert(
        from : String,
        amount : BigDecimal,
        game : String
    ) : ConvertionDto {
        logger.info("GameConversionBl.convert called with params: from=$from, amount=$amount, game=$game")
        val gameCurrency: String
        when (game) {
            "Pokemon" -> {
                gameCurrencyConversionContext.setStrategy(GameCurrencyConversionStrategyPokemon())
                gameCurrency = "POKÉDOLLARS"
            }
            "Animal Crossing" -> {
                gameCurrencyConversionContext.setStrategy(GameCurrencyConversionStrategyAnimalCrossing())
                gameCurrency = "BELLS"
            }
            "Final Fantasy" -> {
                gameCurrencyConversionContext.setStrategy(GameCurrencyConversionStrategyFinalFantasy())
                gameCurrency = "GIL"
            }
            "Kingdom Hearts" -> {
                gameCurrencyConversionContext.setStrategy(GameCurrencyConversionStrategyKingdomHearts())
                gameCurrency = "MUNNY"
            }
            "Super Mario" -> {
                gameCurrencyConversionContext.setStrategy(GameCurrencyConversionStrategySuperMario())
                gameCurrency = "COINS"
            }
            "The Sims" -> {
                gameCurrencyConversionContext.setStrategy(GameCurrencyConversionStrategyTheSims())
                gameCurrency = "SIMOLEONS"
            }
            else -> throw IllegalArgumentException("Game not found")
        }

        logger.info("Calling ConvertionBl.convert with params: from=$from, to=USD, amount=$amount")
        val newConvertedAmount: BigDecimal = convertionBl.makeConvertion(from, "USD", amount).result

        val result: BigDecimal = gameCurrencyConversionContext.convert(newConvertedAmount)
        val query = QueryDto(from, gameCurrency, amount)
        return ConvertionDto(query, result, Date())
    }
}