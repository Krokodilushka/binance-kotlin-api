package com.binance.api.client.domain.rest.margin

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MaxBorrowable(
    @JsonProperty("amount")
    val amount: String,
    @JsonProperty("borrowLimit")
    val borrowLimit: String
)