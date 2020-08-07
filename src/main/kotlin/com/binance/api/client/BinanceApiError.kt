package com.binance.api.client

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties
data class BinanceApiError(
        @JsonProperty("code")
        val code: Int,
        @JsonProperty("msg")
        val msg: String?,
        @JsonProperty("message")
        val message: String?,
        @JsonProperty("error")
        val error: String?,
        @JsonProperty("timestamp")
        val timestamp: Long,
        @JsonProperty("status")
        val status: String?,
        @JsonProperty("path")
        val path: String?
)