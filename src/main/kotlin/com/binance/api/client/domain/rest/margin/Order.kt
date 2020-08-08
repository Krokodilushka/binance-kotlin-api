package com.binance.api.client.domain.rest.margin


import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderStatus
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
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
        val orderId: Long,
        @JsonProperty("origQty")
        val origQty: String,
        @JsonProperty("price")
        val price: String,
        @JsonProperty("side")
        val side: OrderSide,
        @JsonProperty("status")
        val status: OrderStatus,
        @JsonProperty("stopPrice")
        val stopPrice: String,
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("isIsolated")
        val isIsolated: Boolean,
        @JsonProperty("time")
        val time: Long,
        @JsonProperty("timeInForce")
        val timeInForce: OrderTimeInForce,
        @JsonProperty("type")
        val type: OrderType,
        @JsonProperty("updateTime")
        val updateTime: Long,
        @JsonProperty("accountId")
        val accountId: Long
)