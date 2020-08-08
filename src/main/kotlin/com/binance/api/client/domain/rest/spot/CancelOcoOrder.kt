package com.binance.api.client.domain.rest.spot


import com.binance.api.client.domain.*
import com.fasterxml.jackson.annotation.JsonProperty

data class CancelOcoOrder(
        @JsonProperty("orderListId")
        val orderListId: Long,
        @JsonProperty("contingencyType")
        val contingencyType: String,
        @JsonProperty("listStatusType")
        val listStatusType: OcoStatus,
        @JsonProperty("listOrderStatus")
        val listOrderStatus: OcoOrderStatus,
        @JsonProperty("listClientOrderId")
        val listClientOrderId: String,
        @JsonProperty("transactionTime")
        val transactionTime: Long,
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("orders")
        val orders: List<Order>,
        @JsonProperty("orderReports")
        val orderReports: List<OrderReport>
) {
    data class Order(
            @JsonProperty("symbol")
            val symbol: String,
            @JsonProperty("orderId")
            val orderId: Long,
            @JsonProperty("clientOrderId")
            val clientOrderId: String
    )

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
            val side: OrderSide,
            @JsonProperty("stopPrice")
            val stopPrice: String?
    )
}