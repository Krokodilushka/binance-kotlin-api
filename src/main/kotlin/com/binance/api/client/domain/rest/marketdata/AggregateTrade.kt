package com.binance.api.client.domain.rest.marketdata


import com.fasterxml.jackson.annotation.JsonProperty

data class AggregateTrade(
        @JsonProperty("a")
        val id: Int,
        @JsonProperty("p")
        val price: String,
        @JsonProperty("q")
        val qty: String,
        @JsonProperty("f")
        val firstTradeId: Long,
        @JsonProperty("l")
        val lastTradeId: Long,
        @JsonProperty("T")
        val timestamp: Long,
        @JsonProperty("m")
        val isBuyerMaker: Boolean,
        @JsonProperty("M")
        val idBestPriceMatch: Boolean
)