package com.ignacioillanes.CurrencyExchangekotlin.Bl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ignacioillanes.CurrencyExchangekotlin.Dao.repository.CurrencyRepository
import com.ignacioillanes.CurrencyExchangekotlin.Dto.ConvertionDto
import com.ignacioillanes.CurrencyExchangekotlin.Dao.Currency
import com.ignacioillanes.CurrencyExchangekotlin.Exception.ConvertionException
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*
import javax.naming.ServiceUnavailableException

@Service
class ConvertionBl  @Autowired constructor(private val currencyRepository: CurrencyRepository) {
    @Value("\${fixer.api.key}")
    lateinit var API_KEY : String;

    @Value("\${fixer.api.baseurl}")
    lateinit var BASE_URL : String;

    val client = OkHttpClient()
    val objectMapper = jacksonObjectMapper();
    val logger : Logger = LoggerFactory.getLogger(ConvertionBl::class.java)

    fun makeConvertion(
        to: String,
        from: String,
        amount: BigDecimal
    ): ConvertionDto {
        logger.debug("makeConvertion Business Logic initiated")

       if (amount.compareTo(BigDecimal.ZERO) <= 0) {
           logger.error("Amount must be greater than zero")
           throw IllegalArgumentException("Amount must be greater than zero")
       }
        val request = Request.Builder()
            .url("$BASE_URL/convert?to=$to&from=$from&amount=$amount")
            .addHeader("apikey", API_KEY)
            .build()
        try {
            logger.debug("Calling external service")
            val response = client.newCall(request).execute()
            if(!response.isSuccessful)
                throw ConvertionException("Error while converting currency")

            logger.debug("parsing response")
            val jsonString: String = response.body!!.string()
            val convertionDto = objectMapper.readValue<ConvertionDto>(jsonString);

            // Save to database
            val currency = Currency()
            currency.currencyFrom = from
            currency.currencyTo = to
            currency.amount = amount
            currency.result = convertionDto.result
            currency.date = Date()
            
            currencyRepository.save(currency)

            return convertionDto
        } catch (e: Exception) {
            logger.error("Error while calling external service", e)
            throw ServiceUnavailableException("Error while connecting to external service");
        }
    }
}