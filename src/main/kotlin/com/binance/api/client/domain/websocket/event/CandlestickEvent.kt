package com.binance.api.client.domain.websocket.event

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * An interval candlestick for a symbol providing informations on price that can be used to produce candlestick charts.
 */
//@JsonDeserialize(using = CandlestickEventDeserializer::class)
//@JsonSerialize(using = CandlestickEventSerializer::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CandlestickEvent(
        @JsonProperty("e")
        val eventType: String,
        @JsonProperty("E")
        val eventTime: Long,
        @JsonProperty("s")
        val symbol: String,
        @JsonProperty("k")
        val candle: Candle

) {
    data class Candle(
            @JsonProperty("t")
            val openTime: Long,
            @JsonProperty("T")
            val closeTime: Long,
            @JsonProperty("s")
            val symbol: String,
            @JsonProperty("i")
            val interval: String,
            @JsonProperty("f")
            val firstTradeId: Long,
            @JsonProperty("L")
            val lastTradeId: Long,
            @JsonProperty("o")
            val open: String,
            @JsonProperty("c")
            val close: String,
            @JsonProperty("h")
            val high: String,
            @JsonProperty("l")
            val low: String,
            @JsonProperty("v")
            val baseAssetVolume: String,
            @JsonProperty("n")
            val numberOfTrades: Long,
            @JsonProperty("x")
            val isClosed: Boolean,
            @JsonProperty("q")
            val quoteAssetVolume: String,
            @JsonProperty("V")
            val takerBuyBaseAssetVolume: String,
            @JsonProperty("Q")
            val takerBuyQuoteAssetVolume: String,
            @JsonProperty("B")
            val b: String
    )
}
