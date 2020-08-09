package com.binance.api.client.domain.rest.marketdata

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder
@JsonIgnoreProperties(ignoreUnknown = true)
data class Candlestick(
        val openTime: Long,
        val open: String,
        val high: String,
        val low: String,
        val close: String,
        val volume: String,
        val closeTime: Long,
        val quoteAssetVolume: String,
        val numberOfTrades: Long,
        val takerBuyBaseAssetVolume: String,
        val takerBuyQuoteAssetVolume: String
)