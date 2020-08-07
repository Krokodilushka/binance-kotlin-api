package com.binance.api.client.domain.account

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Represents an executed trade history item.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class TradeHistoryItem {
    /**
     * Trade id.
     */
    var id: Long = 0

    /**
     * Price.
     */
    var price: String? = null

    /**
     * Quantity.
     */
    var qty: String? = null

    /**
     * Trade execution time.
     */
    var time: Long = 0

    /**
     * Is buyer maker ?
     */
    @JsonProperty("isBuyerMaker")
    var isBuyerMaker = false

    /**
     * Is best match ?
     */
    @JsonProperty("isBestMatch")
    var isBestMatch = false

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("price", price)
                .append("qty", qty)
                .append("time", time)
                .append("isBuyerMaker", isBuyerMaker)
                .append("isBestMatch", isBestMatch)
                .toString()
    }
}