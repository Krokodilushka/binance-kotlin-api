package com.binance.api.client.domain.market

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * 24 hour price change statistics for a ticker.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class TickerStatistics {
    /**
     * Ticker symbol.
     */
    var symbol: String? = null

    /**
     * Price change during the last 24 hours.
     */
    var priceChange: String? = null

    /**
     * Price change, in percentage, during the last 24 hours.
     */
    var priceChangePercent: String? = null

    /**
     * Weighted average price.
     */
    var weightedAvgPrice: String? = null

    /**
     * Previous close price.
     */
    var prevClosePrice: String? = null

    /**
     * Last price.
     */
    var lastPrice: String? = null

    /**
     * Bid price.
     */
    var bidPrice: String? = null

    /**
     * Ask price.
     */
    var askPrice: String? = null

    /**
     * Open price 24 hours ago.
     */
    var openPrice: String? = null

    /**
     * Highest price during the past 24 hours.
     */
    var highPrice: String? = null

    /**
     * Lowest price during the past 24 hours.
     */
    var lowPrice: String? = null

    /**
     * Total volume during the past 24 hours.
     */
    var volume: String? = null

    /**
     * Open time.
     */
    var openTime: Long = 0

    /**
     * Close time.
     */
    var closeTime: Long = 0

    /**
     * First trade id.
     */
    var firstId: Long = 0

    /**
     * Last trade id.
     */
    var lastId: Long = 0

    /**
     * Total number of trades during the last 24 hours.
     */
    var count: Long = 0

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("priceChange", priceChange)
                .append("priceChangePercent", priceChangePercent)
                .append("weightedAvgPrice", weightedAvgPrice)
                .append("prevClosePrice", prevClosePrice)
                .append("lastPrice", lastPrice)
                .append("bidPrice", bidPrice)
                .append("askPrice", askPrice)
                .append("openPrice", openPrice)
                .append("highPrice", highPrice)
                .append("lowPrice", lowPrice)
                .append("volume", volume)
                .append("openTime", openTime)
                .append("closeTime", closeTime)
                .append("firstId", firstId)
                .append("lastId", lastId)
                .append("count", count)
                .toString()
    }
}