package com.binance.api.client.domain.account.marketdata


import com.fasterxml.jackson.annotation.JsonProperty

data class SymbolPriceTicker(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("price")
        val price: String
)