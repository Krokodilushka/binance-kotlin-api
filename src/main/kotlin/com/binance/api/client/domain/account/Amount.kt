package com.binance.api.client.domain.account

import com.fasterxml.jackson.annotation.JsonProperty

data class Amount(
        @JsonProperty("amount")
        val amount: String
)