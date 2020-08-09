package com.binance.api.client.domain.rest.marketdata


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ServerTime(
        @JsonProperty("serverTime")
        val serverTime: Long
)