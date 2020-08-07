package com.binance.api.client.domain.event

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Order or trade report update event.
 *
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdateEvent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class OrderTradeUpdateEvent {
    @JsonProperty("e")
    var eventType: String? = null

    @JsonProperty("E")
    var eventTime: Long? = null

    @JsonProperty("s")
    var symbol: String? = null

    @JsonProperty("c")
    var newClientOrderId: String? = null

    /**
     * Buy/Sell order side.
     */
    @JsonProperty("S")
    var side: OrderSide? = null

    /**
     * Type of order.
     */
    @JsonProperty("o")
    var type: OrderType? = null

    /**
     * Time in force to indicate how long will the order remain active.
     */
    @JsonProperty("f")
    var timeInForce: TimeInForce? = null

    /**
     * Original quantity in the order.
     */
    @JsonProperty("q")
    var originalQuantity: String? = null

    /**
     * Price.
     */
    @JsonProperty("p")
    var price: String? = null

    /**
     * Type of execution.
     */
    @JsonProperty("x")
    var executionType: ExecutionType? = null

    /**
     * Status of the order.
     */
    @JsonProperty("X")
    var orderStatus: OrderStatus? = null

    /**
     * Reason why the order was rejected.
     */
    @JsonProperty("r")
    var orderRejectReason: OrderRejectReason? = null

    /**
     * Order id.
     */
    @JsonProperty("i")
    var orderId: Long? = null

    /**
     * Quantity of the last filled trade.
     */
    @JsonProperty("l")
    var quantityLastFilledTrade: String? = null

    /**
     * Accumulated quantity of filled trades on this order.
     */
    @JsonProperty("z")
    var accumulatedQuantity: String? = null

    /**
     * Price of last filled trade.
     */
    @JsonProperty("L")
    var priceOfLastFilledTrade: String? = null

    /**
     * Commission.
     */
    @JsonProperty("n")
    var commission: String? = null

    /**
     * Asset on which commission is taken
     */
    @JsonProperty("N")
    var commissionAsset: String? = null

    /**
     * Order/trade time.
     */
    @JsonProperty("T")
    var orderTradeTime: Long? = null

    /**
     * Trade id.
     */
    @JsonProperty("t")
    var tradeId: Long? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("eventType", eventType)
                .append("eventTime", eventTime)
                .append("symbol", symbol)
                .append("newClientOrderId", newClientOrderId)
                .append("side", side)
                .append("type", type)
                .append("timeInForce", timeInForce)
                .append("originalQuantity", originalQuantity)
                .append("price", price)
                .append("executionType", executionType)
                .append("orderStatus", orderStatus)
                .append("orderRejectReason", orderRejectReason)
                .append("orderId", orderId)
                .append("quantityLastFilledTrade", quantityLastFilledTrade)
                .append("accumulatedQuantity", accumulatedQuantity)
                .append("priceOfLastFilledTrade", priceOfLastFilledTrade)
                .append("commission", commission)
                .append("commissionAsset", commissionAsset)
                .append("orderTradeTime", orderTradeTime)
                .append("tradeId", tradeId)
                .toString()
    }
}