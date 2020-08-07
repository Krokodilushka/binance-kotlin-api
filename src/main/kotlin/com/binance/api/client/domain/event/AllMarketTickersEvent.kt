package com.binance.api.client.domain.event

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class AllMarketTickersEvent(
        @JsonProperty("e")
        val eventType: String,
        @JsonProperty("E")
        val eventTime: Long,
        @JsonProperty("s")
        val symbol: String,
        @JsonProperty("p")
        val priceChange: String,
        @JsonProperty("P")
        val priceChangePercent: String,
        @JsonProperty("w")
        val weightedAveragePrice: String,
        @JsonProperty("x")
        val previousDaysClosePrice: String,
        @JsonProperty("c")
        val currentDaysClosePrice: String,
        @JsonProperty("Q")
        val closeTradesQuantity: String,
        @JsonProperty("b")
        val bestBidPrice: String,
        @JsonProperty("B")
        val bestBidQuantity: String,
        @JsonProperty("a")
        val bestAskPrice: String,
        @JsonProperty("A")
        val bestAskQuantity: String,
        @JsonProperty("o")
        val openPrice: String,
        @JsonProperty("h")
        val highPrice: String,
        @JsonProperty("l")
        val lowPrice: String,
        @JsonProperty("v")
        val totalTradedBaseAssetVolume: String,
        @JsonProperty("q")
        val totalTradedQuoteAssetVolume: String,
        @JsonProperty("O")
        val statisticesOpenTime: Long,
        @JsonProperty("C")
        val statisticesCloseTime: Long,
        @JsonProperty("F")
        val firstTradeId: Long,
        @JsonProperty("L")
        val lastTradeId: Long,
        @JsonProperty("n")
        val totalNumberOfTrades: Long
)