package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderStatus
import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.TimeInForce
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Trade order information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Order {
    /**
     * Symbol that the order was put on.
     */
    var symbol: String? = null

    /**
     * Order id.
     */
    var orderId: Long? = null

    /**
     * Client order id.
     */
    var clientOrderId: String? = null

    /**
     * Price.
     */
    var price: String? = null

    /**
     * Original quantity.
     */
    var origQty: String? = null

    /**
     * Original quantity.
     */
    var executedQty: String? = null

    /**
     * Order status.
     */
    var status: OrderStatus? = null

    /**
     * Time in force to indicate how long will the order remain active.
     */
    var timeInForce: TimeInForce? = null

    /**
     * Type of order.
     */
    var type: OrderType? = null

    /**
     * Buy/Sell order side.
     */
    var side: OrderSide? = null

    /**
     * Used with stop orders.
     */
    var stopPrice: String? = null

    /**
     * Used with iceberg orders.
     */
    var icebergQty: String? = null

    /**
     * Order timestamp.
     */
    var time: Long = 0

    /**
     * Used to calculate the average price
     */
    var cummulativeQuoteQty: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("orderId", orderId)
                .append("clientOrderId", clientOrderId)
                .append("price", price)
                .append("origQty", origQty)
                .append("executedQty", executedQty)
                .append("status", status)
                .append("timeInForce", timeInForce)
                .append("type", type)
                .append("side", side)
                .append("stopPrice", stopPrice)
                .append("icebergQty", icebergQty)
                .append("time", time)
                .append("cummulativeQuoteQty", cummulativeQuoteQty)
                .toString()
    }
}