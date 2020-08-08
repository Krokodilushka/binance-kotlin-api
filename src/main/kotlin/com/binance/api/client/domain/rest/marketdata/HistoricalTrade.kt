package com.binance.api.client.domain.rest.marketdata


import com.fasterxml.jackson.annotation.JsonProperty

data class HistoricalTrade(
        @JsonProperty("id")
        val id: Long,
        @JsonProperty("price")
        val price: String,
        @JsonProperty("qty")
        val qty: String,
        @JsonProperty("quoteQty")
        val quoteQty: String,
        @JsonProperty("time")
        val time: Long,
        @JsonProperty("isBuyerMaker")
        val isBuyerMaker: Boolean,
        @JsonProperty("isBestMatch")
        val isBestMatch: Boolean
)