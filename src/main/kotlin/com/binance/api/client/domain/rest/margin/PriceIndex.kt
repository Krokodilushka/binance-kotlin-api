package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PriceIndex(
        @JsonProperty("calcTime")
        val calcTime: Long,
        @JsonProperty("price")
        val price: String,
        @JsonProperty("symbol")
        val symbol: String
)