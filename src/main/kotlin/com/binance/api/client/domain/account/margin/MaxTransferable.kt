package com.binance.api.client.domain.account.margin


import com.fasterxml.jackson.annotation.JsonProperty

data class MaxTransferable(
        @JsonProperty("amount")
        val amount: String
)