package com.binance.api.client.domain.websocket.event

import com.binance.api.client.domain.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Order or trade report update event.
 *
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdateEvent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class OrderTradeUpdateEvent(
        @JsonProperty("e")
        val eventType: String,
        @JsonProperty("E")
        val eventTime: Long,
        @JsonProperty("s")
        val symbol: String,
        @JsonProperty("c")
        val clientOrderID: String,
        @JsonProperty("S")
        val side: OrderSide,
        @JsonProperty("o")
        val orderType: OrderType,
        @JsonProperty("f")
        val timeInForce: OrderTimeInForce,
        @JsonProperty("q")
        val quantity: String,
        @JsonProperty("p")
        val price: String,
        @JsonProperty("P")
        val stopPrice: String,
        @JsonProperty("F")
        val icebergQuantity: String,
        @JsonProperty("g")
        val orderListId: Long,
        @JsonProperty("C")
        val originalClientOrderId: String,
        @JsonProperty("x")
        val currentExecutionType: ExecutionType,
        @JsonProperty("X")
        val currentOrderStatus: OrderStatus,
        @JsonProperty("r")
        val orderRejectReason: OrderRejectReason,
        @JsonProperty("i")
        val orderId: Long,
        @JsonProperty("l")
        val lastExecutedQuantity: String,
        @JsonProperty("z")
        val cumulativeFilledQuantity: String,
        @JsonProperty("L")
        val lastExecutedPrice: String,
        @JsonProperty("n")
        val commissionAmount: String,
        @JsonProperty("N")
        val commissionAsset: String?,
        @JsonProperty("T")
        val transactionTime: Long,
        @JsonProperty("t")
        val tradeId: Long,
        @JsonProperty("I")
        val i: Long,
        @JsonProperty("w")
        val isTheOrderOnTheBook: Boolean,
        @JsonProperty("m")
        val isThisTradeTheMakerSide: Boolean,
        @JsonProperty("M")
        val m: Boolean,
        @JsonProperty("O")
        val orderCreationTime: Long,
        @JsonProperty("Z")
        val cumulativeQuoteAssetTransactedQuantity: String,
        @JsonProperty("Y")
        val lastQuoteAssetTransactedQuantity: String,
        @JsonProperty("Q")
        val quoteOrderQty: String
)