package com.binance.api.client.domain.account.margin

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MarginPair(
        @JsonProperty("base")
        val base: String,
        @JsonProperty("id")
        val id: Long,
        @JsonProperty("isBuyAllowed")
        val isBuyAllowed: Boolean,
        @JsonProperty("isMarginTrade")
        val isMarginTrade: Boolean,
        @JsonProperty("isSellAllowed")
        val isSellAllowed: Boolean,
        @JsonProperty("quote")
        val quote: String,
        @JsonProperty("symbol")
        val symbol: String
)