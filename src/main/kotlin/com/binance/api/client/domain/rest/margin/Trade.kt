package com.binance.api.client.domain.rest.margin


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Trade(
        @JsonProperty("commission")
        val commission: String,
        @JsonProperty("commissionAsset")
        val commissionAsset: String,
        @JsonProperty("id")
        val id: Long,
        @JsonProperty("isBestMatch")
        val isBestMatch: Boolean,
        @JsonProperty("isBuyer")
        val isBuyer: Boolean,
        @JsonProperty("isMaker")
        val isMaker: Boolean,
        @JsonProperty("orderId")
        val orderId: Long,
        @JsonProperty("price")
        val price: String,
        @JsonProperty("qty")
        val qty: String,
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("isIsolated")
        val isIsolated: Boolean,
        @JsonProperty("time")
        val time: Long
)