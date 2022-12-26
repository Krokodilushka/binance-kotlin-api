package com.binance.api.client.domain.rest.spot
import com.fasterxml.jackson.annotation.JsonProperty

data class DepositAddress(
    @JsonProperty("address")
    val address: String,
    @JsonProperty("coin")
    val coin: String,
    @JsonProperty("tag")
    val tag: String,
    @JsonProperty("url")
    val url: String
)