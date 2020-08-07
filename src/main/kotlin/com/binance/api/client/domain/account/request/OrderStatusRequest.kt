package com.binance.api.client.domain.account.request

import com.binance.api.client.constant.BinanceApiConstants
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * A specialized order request with additional filters.
 */
class OrderStatusRequest : OrderRequest {
    var orderId: Long? = null
        private set
    var origClientOrderId: String? = null
        private set

    constructor(symbol: String, orderId: Long?) : super(symbol) {
        this.orderId = orderId
    }

    constructor(symbol: String, origClientOrderId: String?) : super(symbol) {
        this.origClientOrderId = origClientOrderId
    }

    fun orderId(orderId: Long?): OrderStatusRequest {
        this.orderId = orderId
        return this
    }

    fun origClientOrderId(origClientOrderId: String?): OrderStatusRequest {
        this.origClientOrderId = origClientOrderId
        return this
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("origClientOrderId", origClientOrderId)
                .toString()
    }
}