package com.binance.api.client.domain.rest.marketdata


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Ticker24hr(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("priceChange")
        val priceChange: String,
        @JsonProperty("priceChangePercent")
        val priceChangePercent: String,
        @JsonProperty("weightedAvgPrice")
        val weightedAvgPrice: String,
        @JsonProperty("prevClosePrice")
        val prevClosePrice: String,
        @JsonProperty("lastPrice")
        val lastPrice: String,
        @JsonProperty("lastQty")
        val lastQty: String,
        @JsonProperty("bidPrice")
        val bidPrice: String,
        @JsonProperty("bidQty")
        val bidQty: String,
        @JsonProperty("askPrice")
        val askPrice: String,
        @JsonProperty("askQty")
        val askQty: String,
        @JsonProperty("openPrice")
        val openPrice: String,
        @JsonProperty("highPrice")
        val highPrice: String,
        @JsonProperty("lowPrice")
        val lowPrice: String,
        @JsonProperty("volume")
        val volume: String,
        @JsonProperty("quoteVolume")
        val quoteVolume: String,
        @JsonProperty("openTime")
        val openTime: Long,
        @JsonProperty("closeTime")
        val closeTime: Long,
        @JsonProperty("firstId")
        val firstId: Long,
        @JsonProperty("lastId")
        val lastId: Long,
        @JsonProperty("count")
        val count: Long
)