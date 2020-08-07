package com.binance.api.client.domain.account.request

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Response object returned when an order is canceled.
 *
 * @see CancelOrderRequest for the request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class CancelOrderResponse {
    var symbol: String? = null
        private set
    var origClientOrderId: String? = null
        private set
    var orderId: String? = null
        private set
    var clientOrderId: String? = null
        private set
    val status: String? = null
    val executedQty: String? = null

    fun setSymbol(symbol: String?): CancelOrderResponse {
        this.symbol = symbol
        return this
    }

    fun setOrigClientOrderId(origClientOrderId: String?): CancelOrderResponse {
        this.origClientOrderId = origClientOrderId
        return this
    }

    fun setOrderId(orderId: String?): CancelOrderResponse {
        this.orderId = orderId
        return this
    }

    fun setClientOrderId(clientOrderId: String?): CancelOrderResponse {
        this.clientOrderId = clientOrderId
        return this
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("origClientOrderId", origClientOrderId)
                .append("orderId", orderId)
                .append("clientOrderId", clientOrderId)
                .toString()
    }
}