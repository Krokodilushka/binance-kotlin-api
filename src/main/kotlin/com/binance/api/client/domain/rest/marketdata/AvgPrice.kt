package com.binance.api.client.domain.rest.marketdata


import com.fasterxml.jackson.annotation.JsonProperty

data class AvgPrice(
        @JsonProperty("mins")
        val mins: Int,
        @JsonProperty("price")
        val price: String
)