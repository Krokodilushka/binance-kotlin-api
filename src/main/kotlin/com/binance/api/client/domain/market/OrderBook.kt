package com.binance.api.client.domain.market

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Order book of a symbol in Binance.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class OrderBook {
    /**
     * Last update id of this order book.
     */
    var lastUpdateId: Long = 0

    /**
     * List of bids (price/qty).
     */
    var bids: List<OrderBookEntry>? = null

    /**
     * List of asks (price/qty).
     */
    var asks: List<OrderBookEntry>? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("lastUpdateId", lastUpdateId)
                .append("bids", bids)
                .append("asks", asks)
                .toString()
    }
}