package com.binance.api.client.domain.rest.spot


import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderStatus
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.fasterxml.jackson.annotation.JsonProperty

data class CancelOrder(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("origClientOrderId")
        val origClientOrderId: String,
        @JsonProperty("orderId")
        val orderId: Long,
        @JsonProperty("orderListId")
        val orderListId: Long,
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