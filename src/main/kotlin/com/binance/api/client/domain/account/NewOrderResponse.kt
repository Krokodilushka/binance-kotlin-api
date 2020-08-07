package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderStatus
import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.TimeInForce
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder
import java.util.*
import java.util.stream.Collectors

/**
 * Response returned when placing a new order on the system.
 *
 * @see NewOrder for the request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class NewOrderResponse {
    /**
     * Order symbol.
     */
    var symbol: String? = null

    /**
     * Order id.
     */
    var orderId: Long? = null

    /**
     * This will be either a generated one, or the newClientOrderId parameter
     * which was passed when creating the new order.
     */
    var clientOrderId: String? = null
    var price: String? = null
    var origQty: String? = null
    var executedQty: String? = null
    var cummulativeQuoteQty: String? = null
    var status: OrderStatus? = null
    var timeInForce: TimeInForce? = null
    var type: OrderType? = null
    var side: OrderSide? = null

    // @JsonSetter(nulls = Nulls.AS_EMPTY)
    var fills: List<Trade>? = null

    /**
     * Transact time for this order.
     */
    var transactTime: Long? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("orderId", orderId)
                .append("clientOrderId", clientOrderId)
                .append("transactTime", transactTime)
                .append("price", price)
                .append("origQty", origQty)
                .append("executedQty", executedQty)
                .append("status", status)
                .append("timeInForce", timeInForce)
                .append("type", type)
                .append("side", side)
                .append("fills", Optional.ofNullable(fills).orElse(emptyList())
                        .stream()
                        .map { obj: Trade -> obj.toString() }
                        .collect(Collectors.joining(", ")))
                .toString()
    }
}