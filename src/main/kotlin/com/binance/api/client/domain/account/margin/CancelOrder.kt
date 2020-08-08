package com.binance.api.client.domain.account.margin


import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderStatus
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.fasterxml.jackson.annotation.JsonProperty

data class CancelOrder(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("isIsolated")
        val isIsolated: Boolean,
        @JsonProperty("orderId")
        val orderId: Long,
        @JsonProperty("origClientOrderId")
        val origClientOrderId: String,
        @JsonProperty("clientOrderId")
        val clientOrderId: String,
        @JsonProperty("price")
        val price: String,
        @JsonProperty("origQty")
        val origQty: String,
        @JsonProperty("executedQty")
        val executedQty: String,
        @JsonProperty("cummulativeQuoteQty")
        val cummulativeQuoteQty: String,
        @JsonProperty("status")
        val status: OrderStatus,
        @JsonProperty("timeInForce")
        val timeInForce: OrderTimeInForce,
        @JsonProperty("type")
        val type: OrderType,
        @JsonProperty("side")
        val side: OrderSide
)