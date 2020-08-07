package com.binance.api.client.domain.account.margin


import com.fasterxml.jackson.annotation.JsonProperty

data class CreateIsolatedAccount(
        @JsonProperty("success")
        val success: Boolean,
        @JsonProperty("symbol")
        val symbol: String
)