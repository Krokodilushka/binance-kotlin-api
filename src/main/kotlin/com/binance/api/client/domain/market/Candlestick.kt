package com.binance.api.client.domain.market

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Kline/Candlestick bars for a symbol. Klines are uniquely identified by their open time.
 */
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder
@JsonIgnoreProperties(ignoreUnknown = true)
class Candlestick {
    var openTime: Long? = null
    var open: String? = null
    var high: String? = null
    var low: String? = null
    var close: String? = null
    var volume: String? = null
    var closeTime: Long? = null
    var quoteAssetVolume: String? = null
    var numberOfTrades: Long? = null
    var takerBuyBaseAssetVolume: String? = null
    var takerBuyQuoteAssetVolume: String? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("openTime", openTime)
                .append("open", open)
                .append("high", high)
                .append("low", low)
                .append("close", close)
                .append("volume", volume)
                .append("closeTime", closeTime)
                .append("quoteAssetVolume", quoteAssetVolume)
                .append("numberOfTrades", numberOfTrades)
                .append("takerBuyBaseAssetVolume", takerBuyBaseAssetVolume)
                .append("takerBuyQuoteAssetVolume", takerBuyQuoteAssetVolume)
                .toString()
    }
}