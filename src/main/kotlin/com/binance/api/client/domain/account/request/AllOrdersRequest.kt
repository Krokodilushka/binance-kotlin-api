package com.binance.api.client.domain.account.request

import com.binance.api.client.constant.BinanceApiConstants
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * A specialized order request with additional filters.
 */
class AllOrdersRequest(symbol: String) : OrderRequest(symbol) {
    var orderId: Long? = null
        private set
    var limit: Int
        private set

    fun orderId(orderId: Long?): AllOrdersRequest {
        this.orderId = orderId
        return this
    }

    fun limit(limit: Int): AllOrdersRequest {
        this.limit = limit
        return this
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("limit", limit)
                .toString()
    }

    companion object {
        private const val DEFAULT_LIMIT = 500
    }

    init {
        limit = DEFAULT_LIMIT
    }
}