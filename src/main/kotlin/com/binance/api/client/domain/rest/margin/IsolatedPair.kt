package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
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