package com.binance.api.client.domain.account.marketdata


import com.fasterxml.jackson.annotation.JsonProperty

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