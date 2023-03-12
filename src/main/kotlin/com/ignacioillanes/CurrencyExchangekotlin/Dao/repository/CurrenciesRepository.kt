package com.ignacioillanes.CurrencyExchangekotlin.Dao.repository

import com.ignacioillanes.CurrencyExchangekotlin.Dao.Currency
import org.springframework.data.repository.PagingAndSortingRepository

interface CurrenciesRepository : PagingAndSortingRepository<Currency, Long> {
    fun findByCurrencyFromAndCurrencyTo(currencyFrom: String, currencyTo: String): List<Currency>
}