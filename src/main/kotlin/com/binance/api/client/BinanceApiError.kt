package com.binance.api.client

import com.binance.api.client.constant.BinanceApiConstants
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Binance API error object.
 */
class BinanceApiError {
    /**
     * Error code.
     */
    var code = 0

    /**
     * Error message.
     */
    var msg: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("code", code)
                .append("msg", msg)
                .toString()
    }
}