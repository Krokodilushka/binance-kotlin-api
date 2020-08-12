package com.binance.api.client.domain.websocket.deserializer

import com.binance.api.client.exception.BinanceApiException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.IOException

object JsonToObject {

    private var mapper = ObjectMapper().registerKotlinModule()

    fun <T> convert(json: String?, clazz: Class<T>): T {
        return try {
            mapper.readValue(json, clazz)
        } catch (e: IOException) {
            throw BinanceApiException(e)
        }
    }

    fun <T> convert(json: String?, clazz: TypeReference<T>): T {
        return try {
            mapper.readValue(json, clazz)
        } catch (e: IOException) {
            throw BinanceApiException(e)
        }
    }
}