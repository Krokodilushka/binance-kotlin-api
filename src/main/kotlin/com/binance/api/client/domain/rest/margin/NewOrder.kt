package com.binance.api.client.domain.rest.margin


import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderStatus
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class NewOrder(
        @JsonProperty("symbol")
        val symbol: String,
        @JsonProperty("orderId")
        val orderId: Long,
        @JsonProperty("clientOrderId")
        val clientOrderId: String,
        @JsonProperty("transactTime")
        val transactTime: Long,
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
        @JsonProperty("marginBuyBorrowAmount")
        val marginBuyBorrowAmount: Int?,
        @JsonProperty("marginBuyBorrowAsset")
        val marginBuyBorrowAsset: String?,
        @JsonProperty("isIsolated")
        val isIsolated: Boolean,
        @JsonProperty("fills")
        val fills: List<Fill>
) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Fill(
                @JsonProperty("price")
                val price: String,
                @JsonProperty("qty")
                val qty: String,
                @JsonProperty("commission")
                val commission: String,
                @JsonProperty("commissionAsset")
                val commissionAsset: String
        )
}