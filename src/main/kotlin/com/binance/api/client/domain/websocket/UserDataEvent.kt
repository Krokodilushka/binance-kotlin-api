package com.binance.api.client.domain.websocket

import com.binance.api.client.domain.*
import com.binance.api.client.domain.rest.spot.Account
import com.binance.api.client.domain.websocket.deserializer.AssetBalanceDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

sealed class UserDataEvent {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class AccountUpdateEvent(
            @JsonProperty("e")
            val eventType: String,
            @JsonProperty("E")
            val eventTime: Long,

            @JsonProperty("m")
            val makerCommissionRate: Long? = null,
            @JsonProperty("t")
            val takerCommissionRate: Long? = null,
            @JsonProperty("b")
            val buyerCommissionRate: Long? = null,
            @JsonProperty("s")
            val sellerCommissionRate: Long? = null,
            @JsonProperty("T")
            val canTrade: Boolean? = null,
            @JsonProperty("W")
            val canWithdraw: Boolean? = null,
            @JsonProperty("D")
            val canDeposit: Boolean? = null,
            @JsonProperty("u")
            val timeOfLastAccountUpdate: Long? = null,

            @JsonProperty("B")
            @JsonDeserialize(contentUsing = AssetBalanceDeserializer::class)
            val balances: List<Account.Balance>,

            @JsonProperty("P")
            val permissions: List<Permission>? = null
    ) : UserDataEvent()

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class BalanceUpdateEvent(
            @JsonProperty("e")
            val eventType: String,
            @JsonProperty("E")
            val eventTime: Long,
            @JsonProperty("a")
            val asset: String,
            @JsonProperty("d")
            val balanceDelta: String,
            @JsonProperty("T")
            val clearTime: Long
    ) : UserDataEvent()


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
    ) : UserDataEvent()

}