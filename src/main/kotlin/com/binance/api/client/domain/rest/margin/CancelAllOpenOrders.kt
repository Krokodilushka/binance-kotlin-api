package com.binance.api.client.domain.rest.margin


import com.binance.api.client.domain.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CancelAllOpenOrders(
    @JsonProperty("symbol")
    val symbol: String,
    @JsonProperty("isIsolated")
    val isIsolated: Boolean,
    @JsonProperty("origClientOrderId")
    val origClientOrderId: String?,
    @JsonProperty("orderId")
    val orderId: Long,
    @JsonProperty("orderListId")
    val orderListId: Long,
    @JsonProperty("clientOrderId")
    val clientOrderId: String?,
    @JsonProperty("price")
    val price: String?,
    @JsonProperty("origQty")
    val origQty: String?,
    @JsonProperty("executedQty")
    val executedQty: String?,
    @JsonProperty("cummulativeQuoteQty")
    val cummulativeQuoteQty: String?,
    @JsonProperty("status")
    val status: OrderStatus?,
    @JsonProperty("timeInForce")
    val timeInForce: OrderTimeInForce?,
    @JsonProperty("type")
    val type: OrderType?,
    @JsonProperty("side")
    val side: OrderSide?,
    @JsonProperty("contingencyType")
    val contingencyType: ContingencyType?,
    @JsonProperty("listStatusType")
    val listStatusType: ListStatusType?,
    @JsonProperty("listOrderStatus")
    val listOrderStatus: ListOrderStatus?,
    @JsonProperty("listClientOrderId")
    val listClientOrderId: String?,
    @JsonProperty("transactionTime")
    val transactionTime: Long,
    @JsonProperty("orders")
    val orders: List<Order>?,
    @JsonProperty("orderReports")
    val orderReports: List<OrderReport>?
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Order(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("orderId")
        val orderId: Long,
        @JsonProperty("clientOrderId")
        val clientOrderId: String
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class OrderReport(
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
        val side: String,
        @JsonProperty("stopPrice")
        val stopPrice: String?,
        @JsonProperty("icebergQty")
        val icebergQty: String?
    )
}