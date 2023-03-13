package com.ignacioillanes.CurrencyExchangekotlin.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CorsConfig {
    @Bean
    fun corsFilter() = org.springframework.web.filter.CorsFilter(org.springframework.web.cors.UrlBasedCorsConfigurationSource().apply {
        registerCorsConfiguration("/**", org.springframework.web.cors.CorsConfiguration().apply {
            allowedOrigins = listOf("http://localhost:4200")
            allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
            allowedHeaders = listOf("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers")
            exposedHeaders = listOf("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
            maxAge = 3600
        })
    })
}