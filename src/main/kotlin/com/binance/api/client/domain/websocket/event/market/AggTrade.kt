package com.binance.api.client.domain.websocket.event.market

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * An aggregated trade event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
open class AggTrade {
    @JsonProperty("a")
    var aggregatedTradeId: Long = 0

    @JsonProperty("p")
    var price: String? = null

    @JsonProperty("q")
    var quantity: String? = null

    @JsonProperty("f")
    var firstBreakdownTradeId: Long = 0

    @JsonProperty("l")
    var lastBreakdownTradeId: Long = 0

    @JsonProperty("T")
    var tradeTime: Long = 0

    @JsonProperty("m")
    var isBuyerMaker = false

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("aggregatedTradeId", aggregatedTradeId)
                .append("price", price)
                .append("quantity", quantity)
                .append("firstBreakdownTradeId", firstBreakdownTradeId)
                .append("lastBreakdownTradeId", lastBreakdownTradeId)
                .append("tradeTime", tradeTime)
                .append("isBuyerMaker", isBuyerMaker)
                .toString()
    }
}