package com.binance.api.client.domain.account.margin


import com.fasterxml.jackson.annotation.JsonProperty

data class PriceIndex(
        @JsonProperty("calcTime")
        val calcTime: Long,
        @JsonProperty("price")
        val price: String,
        @JsonProperty("symbol")
        val symbol: String
)