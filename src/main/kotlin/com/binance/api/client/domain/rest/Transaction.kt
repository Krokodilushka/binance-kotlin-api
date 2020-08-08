package com.binance.api.client.domain.rest

import com.fasterxml.jackson.annotation.JsonProperty

data class Transaction(
        @JsonProperty("tranId")
        val id: Long
)