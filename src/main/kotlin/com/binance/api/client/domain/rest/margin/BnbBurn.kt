package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BnbBurn(
    @JsonProperty("spotBNBBurn")
    val spotBNBBurn: Boolean,
    @JsonProperty("interestBNBBurn")
    val interestBNBBurn: Boolean
)