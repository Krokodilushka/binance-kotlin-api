package com.binance.api.client.domain.event

import com.binance.api.client.domain.event.market.OrderBookEntry
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Depth delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class DepthEvent(
        @JsonProperty("e")
        val eventType: String,
        @JsonProperty("E")
        val eventTime: Long,
        @JsonProperty("s")
        val symbol: String,
        @JsonProperty("U")
        val firstUpdateId: Long,
        @JsonProperty("u")
        val finalUpdateId: Long,
        @JsonProperty("b")
        val bids: List<OrderBookEntry>,
        @JsonProperty("a")
        val asks: List<OrderBookEntry>
)