package com.binance.api.client.domain.general

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder

@JsonIgnoreProperties(ignoreUnknown = true)
class MarginPair {
    var id: Long? = null
    var symbol: String? = null
    var base: String? = null
    var quote: String? = null
    var isBuyAllowed: Boolean? = null
    var isMarginTrade: Boolean? = null
    var isSellAllowed: Boolean? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("symbol", symbol)
                .append("base", base)
                .append("quote", quote)
                .append("buyAllowed", isBuyAllowed)
                .append("marginTrade", isMarginTrade)
                .append("sellAllowed", isSellAllowed)
                .toString()
    }
}