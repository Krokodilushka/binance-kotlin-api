package com.binance.api.client.domain.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BinanceApiError(
        @JsonProperty("code")
        val code: Int,
        @JsonProperty("msg")
        val msg: String
)