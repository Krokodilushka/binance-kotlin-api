package com.binance.api.client.domain.event.market

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * An order book entry consisting of price and quantity.
 */
@JsonDeserialize(using = OrderBookEntryDeserializer::class)
@JsonSerialize(using = OrderBookEntrySerializer::class)
@JsonIgnoreProperties(ignoreUnknown = true)
class OrderBookEntry {
    var price: String? = null
    var qty: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("price", price)
                .append("qty", qty)
                .toString()
    }
}