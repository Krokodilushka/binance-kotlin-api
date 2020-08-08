package com.binance.api.client.domain.account.marketdata


import com.fasterxml.jackson.annotation.JsonProperty

data class ServerTime(
        @JsonProperty("serverTime")
        val serverTime: Long
)