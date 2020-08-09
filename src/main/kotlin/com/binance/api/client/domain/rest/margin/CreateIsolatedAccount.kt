package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CreateIsolatedAccount(
        @JsonProperty("success")
        val success: Boolean,
        @JsonProperty("symbol")
        val symbol: String
)