package com.binance.api.client.domain.rest.spot


import com.fasterxml.jackson.annotation.JsonProperty

data class Trade(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("id")
        val id: Long,
        @JsonProperty("orderId")
        val orderId: Long,
        @JsonProperty("orderListId")
        val orderListId: Long,
        @JsonProperty("price")
        val price: String,
        @JsonProperty("qty")
        val qty: String,
        @JsonProperty("quoteQty")
        val quoteQty: String,
        @JsonProperty("commission")
        val commission: String,
        @JsonProperty("commissionAsset")
        val commissionAsset: String,
        @JsonProperty("time")
        val time: Long,
        @JsonProperty("isBuyer")
        val isBuyer: Boolean,
        @JsonProperty("isMaker")
        val isMaker: Boolean,
        @JsonProperty("isBestMatch")
        val isBestMatch: Boolean
)