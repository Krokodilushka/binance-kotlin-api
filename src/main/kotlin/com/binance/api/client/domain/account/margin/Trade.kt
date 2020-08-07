package com.binance.api.client.domain.account.margin


import com.fasterxml.jackson.annotation.JsonProperty

data class Trade(
        @JsonProperty("commission")
        val commission: String,
        @JsonProperty("commissionAsset")
        val commissionAsset: String,
        @JsonProperty("id")
        val id: Int,
        @JsonProperty("isBestMatch")
        val isBestMatch: Boolean,
        @JsonProperty("isBuyer")
        val isBuyer: Boolean,
        @JsonProperty("isMaker")
        val isMaker: Boolean,
        @JsonProperty("orderId")
        val orderId: Int,
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