package com.binance.api.client.domain.event

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.market.OrderBookEntry
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Depth delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class DepthEvent {
    @JsonProperty("e")
    var eventType: String? = null

    @JsonProperty("E")
    var eventTime: Long = 0

    @JsonProperty("s")
    var symbol: String? = null

    @JsonProperty("U")
    var firstUpdateId: Long = 0

    @JsonProperty("u")
    var finalUpdateId: Long = 0

    /**
     * updateId to sync up with updateid in /api/v1/depth
     */
    @JsonProperty("u")
    var updateId: Long = 0
        @Deprecated("Use {@link #getFinalUpdateId}") get
        @Deprecated("Use {@link #setFinalUpdateId}") set

    /**
     * Bid depth delta.
     */
    @JsonProperty("b")
    var bids: List<OrderBookEntry>? = null

    /**
     * Ask depth delta.
     */
    @JsonProperty("a")
    var asks: List<OrderBookEntry>? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("eventType", eventType)
                .append("eventTime", eventTime)
                .append("symbol", symbol)
                .append("firstUpdateId", firstUpdateId)
                .append("finalUpdateId", finalUpdateId)
                .append("bids", bids)
                .append("asks", asks)
                .toString()
    }
}