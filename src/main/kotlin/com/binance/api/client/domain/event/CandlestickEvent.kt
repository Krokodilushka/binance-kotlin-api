package com.binance.api.client.domain.event

import com.binance.api.client.domain.event.deserializer.CandlestickEventDeserializer
import com.binance.api.client.domain.event.serializer.CandlestickEventSerializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize

/**
 * An interval candlestick for a symbol providing informations on price that can be used to produce candlestick charts.
 */
@JsonDeserialize(using = CandlestickEventDeserializer::class)
@JsonSerialize(using = CandlestickEventSerializer::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CandlestickEvent(
        val eventType: String,
        val eventTime: Long,
        val symbol: String,
        val openTime: Long,
        val closeTime: Long,
        val interval: String,
        val firstTradeId: Long,
        val lastTradeId: Long,
        val open: String,
        val close: String,
        val high: String,
        val low: String,
        val baseAssetVolume: String,
        val numberOfTrades: Long,
        val isClosed: Boolean,
        val quoteAssetVolume: String,
        val takerBuyBaseAssetVolume: String,
        val takerBuyQuoteAssetVolume: String
)