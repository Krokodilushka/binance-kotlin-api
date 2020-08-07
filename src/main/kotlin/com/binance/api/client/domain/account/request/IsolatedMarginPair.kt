package com.binance.api.client.domain.account.request


import com.fasterxml.jackson.annotation.JsonProperty

data class IsolatedMarginPair(
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