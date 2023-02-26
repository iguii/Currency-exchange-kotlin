package com.ignacioillanes.CurrencyExchangekotlin.Dao.repository

import com.ignacioillanes.CurrencyExchangekotlin.Dao.Currency
import org.springframework.data.repository.CrudRepository

interface CurrencyRepository : CrudRepository<Currency, Long> {
    override fun <S : Currency> save(entity: S): S
}