package com.binance.api.client.domain.account.margin


import com.fasterxml.jackson.annotation.JsonProperty

data class Order(
        @JsonProperty("clientOrderId")
        val clientOrderId: String,
        @JsonProperty("cummulativeQuoteQty")
        val cummulativeQuoteQty: String,
        @JsonProperty("executedQty")
        val executedQty: String,
        @JsonProperty("icebergQty")
        val icebergQty: String,
        @JsonProperty("isWorking")
        val isWorking: Boolean,
        @JsonProperty("orderId")
        val orderId: Int,
        @JsonProperty("origQty")
        val origQty: String,
        @JsonProperty("price")
        val price: String,
        @JsonProperty("side")
        val side: String,
        @JsonProperty("status")
        val status: String,
        @JsonProperty("stopPrice")
        val stopPrice: String,
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("isIsolated")
        val isIsolated: Boolean,
        @JsonProperty("time")
        val time: Long,
        @JsonProperty("timeInForce")
        val timeInForce: String,
        @JsonProperty("type")
        val type: String,
        @JsonProperty("updateTime")
        val updateTime: Long
)