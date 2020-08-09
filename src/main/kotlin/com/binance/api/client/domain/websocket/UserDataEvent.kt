package com.binance.api.client.domain.websocket

import com.binance.api.client.domain.*
import com.binance.api.client.domain.websocket.deserializer.UserDataUpdateEventDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(using = UserDataUpdateEventDeserializer::class)
data class UserDataEvent(val event: Event) {

        sealed class Event {
                @JsonIgnoreProperties(ignoreUnknown = true)
                data class AccountUpdateEvent(
                        @JsonProperty("e")
                        val eventType: String,
                        @JsonProperty("E")
                        val eventTime: Long,
                        @JsonProperty("m")
                        val makerCommissionRate: Long,
                        @JsonProperty("t")
                        val takerCommissionRate: Long,
                        @JsonProperty("b")
                        val buyerCommissionRate: Long,
                        @JsonProperty("s")
                        val sellerCommissionRate: Long,
                        @JsonProperty("T")
                        val canTrade: Boolean,
                        @JsonProperty("W")
                        val canWithdraw: Boolean,
                        @JsonProperty("D")
                        val canDeposit: Boolean,
                        @JsonProperty("u")
                        val timeOfLastAccountUpdate: Long,
                        @JsonProperty("B")
                        val balances: List<Balance>,
                        @JsonProperty("P")
                        val permissions: List<Permission>?
                ) : Event() {
                        data class Balance(
                                @JsonProperty("a")
                                val asset: String,
                                @JsonProperty("f")
                                val free: String,
                                @JsonProperty("l")
                                val locked: String
                        )
                }

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
                ) : Event()


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
                ) : Event()

        }
}