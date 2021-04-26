package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MarginInterestRateHistory(
    @JsonProperty("asset")
    val asset: String,
    @JsonProperty("dailyInterestRate")
    val dailyInterestRate: String,
    @JsonProperty("timestamp")
    val timestamp: Long,
    @JsonProperty("vipLevel")
    val vipLevel: Int
)