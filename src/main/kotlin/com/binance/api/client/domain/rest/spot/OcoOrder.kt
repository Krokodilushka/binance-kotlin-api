package com.binance.api.client.domain.rest.spot


import com.binance.api.client.domain.OcoOrderStatus
import com.binance.api.client.domain.OcoStatus
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class OcoOrder(
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
        val orders: List<Order>
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
}