package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.TimeInForce
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * A trade order to enter or exit a position.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class NewOrder(
        /**
         * Symbol to place the order on.
         */
        var symbol: String?,
        /**
         * Buy/Sell order side.
         */
        var side: OrderSide?,
        /**
         * Type of order.
         */
        var type: OrderType?,
        /**
         * Time in force to indicate how long will the order remain active.
         */
        var timeInForce: TimeInForce?,
        /**
         * Quantity.
         */
        var quantity: String?) {

    /**
     * Price.
     */
    var price: String? = null
        private set

    /**
     * A unique id for the order. Automatically generated if not sent.
     */
    var newClientOrderId: String? = null
        private set

    /**
     * Used with stop orders.
     */
    var stopPrice: String? = null
        private set

    /**
     * Used with iceberg orders.
     */
    var icebergQty: String? = null
        private set

    /**
     * Set the response JSON. ACK, RESULT, or FULL; default: RESULT.
     */
    var newOrderRespType: NewOrderResponseType
        private set

    /**
     * Receiving window.
     */
    var recvWindow: Long
        private set

    /**
     * Order timestamp.
     */
    var timestamp: Long
        private set

    /**
     * Creates a new order with all required parameters plus price, which is optional for MARKET orders.
     */
    constructor(symbol: String?, side: OrderSide?, type: OrderType?, timeInForce: TimeInForce?, quantity: String?, price: String?) : this(symbol, side, type, timeInForce, quantity) {
        this.price = price
    }

    fun symbol(symbol: String?): NewOrder {
        this.symbol = symbol
        return this
    }

    fun side(side: OrderSide?): NewOrder {
        this.side = side
        return this
    }

    fun type(type: OrderType?): NewOrder {
        this.type = type
        return this
    }

    fun timeInForce(timeInForce: TimeInForce?): NewOrder {
        this.timeInForce = timeInForce
        return this
    }

    fun quantity(quantity: String?): NewOrder {
        this.quantity = quantity
        return this
    }

    fun price(price: String?): NewOrder {
        this.price = price
        return this
    }

    fun newClientOrderId(newClientOrderId: String?): NewOrder {
        this.newClientOrderId = newClientOrderId
        return this
    }

    fun stopPrice(stopPrice: String?): NewOrder {
        this.stopPrice = stopPrice
        return this
    }

    fun icebergQty(icebergQty: String?): NewOrder {
        this.icebergQty = icebergQty
        return this
    }

    fun newOrderRespType(newOrderRespType: NewOrderResponseType): NewOrder {
        this.newOrderRespType = newOrderRespType
        return this
    }

    fun recvWindow(recvWindow: Long): NewOrder {
        this.recvWindow = recvWindow
        return this
    }

    fun timestamp(timestamp: Long): NewOrder {
        this.timestamp = timestamp
        return this
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("side", side)
                .append("type", type)
                .append("timeInForce", timeInForce)
                .append("quantity", quantity)
                .append("price", price)
                .append("newClientOrderId", newClientOrderId)
                .append("stopPrice", stopPrice)
                .append("icebergQty", icebergQty)
                .append("newOrderRespType", newOrderRespType)
                .append("recvWindow", recvWindow)
                .append("timestamp", timestamp)
                .toString()
    }

    companion object {
        /**
         * Places a MARKET buy order for the given `quantity`.
         *
         * @return a new order which is pre-configured with MARKET as the order type and BUY as the order side.
         */
        fun marketBuy(symbol: String?, quantity: String?): NewOrder {
            return NewOrder(symbol, OrderSide.BUY, OrderType.MARKET, null, quantity)
        }

        /**
         * Places a MARKET sell order for the given `quantity`.
         *
         * @return a new order which is pre-configured with MARKET as the order type and SELL as the order side.
         */
        fun marketSell(symbol: String?, quantity: String?): NewOrder {
            return NewOrder(symbol, OrderSide.SELL, OrderType.MARKET, null, quantity)
        }

        /**
         * Places a LIMIT buy order for the given `quantity` and `price`.
         *
         * @return a new order which is pre-configured with LIMIT as the order type and BUY as the order side.
         */
        fun limitBuy(symbol: String?, timeInForce: TimeInForce?, quantity: String?, price: String?): NewOrder {
            return NewOrder(symbol, OrderSide.BUY, OrderType.LIMIT, timeInForce, quantity, price)
        }

        /**
         * Places a LIMIT sell order for the given `quantity` and `price`.
         *
         * @return a new order which is pre-configured with LIMIT as the order type and SELL as the order side.
         */
        fun limitSell(symbol: String?, timeInForce: TimeInForce?, quantity: String?, price: String?): NewOrder {
            return NewOrder(symbol, OrderSide.SELL, OrderType.LIMIT, timeInForce, quantity, price)
        }
    }

    /**
     * Creates a new order with all required parameters.
     */
    init {
        newOrderRespType = NewOrderResponseType.RESULT
        timestamp = System.currentTimeMillis()
        recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW
    }
}