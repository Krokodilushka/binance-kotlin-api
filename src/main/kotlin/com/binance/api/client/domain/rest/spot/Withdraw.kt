package com.binance.api.client.domain.rest.spot
import com.fasterxml.jackson.annotation.JsonProperty

data class Withdraw(
    @JsonProperty("id")
    val id: String
)