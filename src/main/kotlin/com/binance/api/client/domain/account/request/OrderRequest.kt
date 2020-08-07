package com.binance.api.client.domain.account.request

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Base request parameters for order-related methods.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
open class OrderRequest(val symbol: String) {
    var recvWindow: Long
        private set
    var timestamp: Long
        private set

    fun recvWindow(recvWindow: Long): OrderRequest {
        this.recvWindow = recvWindow
        return this
    }

    fun timestamp(timestamp: Long): OrderRequest {
        this.timestamp = timestamp
        return this
    }

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("recvWindow", recvWindow)
                .append("timestamp", timestamp)
                .toString()
    }

    init {
        timestamp = System.currentTimeMillis()
        recvWindow = BinanceApiConstants.SPOT_RECEIVING_WINDOW
    }
}