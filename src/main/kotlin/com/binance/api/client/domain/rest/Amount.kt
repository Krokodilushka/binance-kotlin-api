package com.binance.api.client.domain.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Amount(
        @JsonProperty("amount")
        val amount: String
)