package com.binance.api.client.domain.market

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Wraps a symbol and its corresponding latest price.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class TickerPrice {
    /**
     * Ticker symbol.
     */
    var symbol: String? = null

    /**
     * Latest price.
     */
    var price: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("price", price)
                .toString()
    }
}