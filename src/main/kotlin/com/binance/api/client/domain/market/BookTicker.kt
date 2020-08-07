package com.binance.api.client.domain.market

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Represents the best price/qty on the order book for a given symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class BookTicker {
    /**
     * Ticker symbol.
     */
    var symbol: String? = null

    /**
     * Bid price.
     */
    var bidPrice: String? = null

    /**
     * Bid quantity
     */
    var bidQty: String? = null

    /**
     * Ask price.
     */
    var askPrice: String? = null

    /**
     * Ask quantity.
     */
    var askQty: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("bidPrice", bidPrice)
                .append("bidQty", bidQty)
                .append("askPrice", askPrice)
                .append("askQty", askQty)
                .toString()
    }
}