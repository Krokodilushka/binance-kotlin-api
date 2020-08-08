package com.binance.api.client.domain.account.margin


import com.fasterxml.jackson.annotation.JsonProperty

data class IsolatedPair(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("base")
        val base: String,
        @JsonProperty("quote")
        val quote: String,
        @JsonProperty("isMarginTrade")
        val isMarginTrade: Boolean,
        @JsonProperty("isBuyAllowed")
        val isBuyAllowed: Boolean,
        @JsonProperty("isSellAllowed")
        val isSellAllowed: Boolean
)