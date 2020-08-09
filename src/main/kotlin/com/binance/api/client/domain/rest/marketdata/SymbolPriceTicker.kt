package com.binance.api.client.domain.rest.marketdata


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SymbolPriceTicker(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("price")
        val price: String
)