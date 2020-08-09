package com.binance.api.client.domain.rest.marketdata


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SymbolOrderBookTicker(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("bidPrice")
        val bidPrice: String,
        @JsonProperty("bidQty")
        val bidQty: String,
        @JsonProperty("askPrice")
        val askPrice: String,
        @JsonProperty("askQty")
        val askQty: String
)