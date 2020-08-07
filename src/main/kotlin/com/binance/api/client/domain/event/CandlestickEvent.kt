package com.binance.api.client.domain.event

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * An interval candlestick for a symbol providing informations on price that can be used to produce candlestick charts.
 */
@JsonDeserialize(using = CandlestickEventDeserializer::class)
@JsonSerialize(using = CandlestickEventSerializer::class)
@JsonIgnoreProperties(ignoreUnknown = true)
class CandlestickEvent {
    var eventType: String? = null
    var eventTime: Long = 0
    var symbol: String? = null
    var openTime: Long? = null
    var open: String? = null
    var high: String? = null
    var low: String? = null
    var close: String? = null
    var volume: String? = null
    var closeTime: Long? = null
    var intervalId: String? = null
    var firstTradeId: Long? = null
    var lastTradeId: Long? = null
    var quoteAssetVolume: String? = null
    var numberOfTrades: Long? = null
    var takerBuyBaseAssetVolume: String? = null
    var takerBuyQuoteAssetVolume: String? = null
    var barFinal: Boolean? = null

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("eventType", eventType)
                .append("eventTime", eventTime)
                .append("symbol", symbol)
                .append("openTime", openTime)
                .append("open", open)
                .append("high", high)
                .append("low", low)
                .append("close", close)
                .append("volume", volume)
                .append("closeTime", closeTime)
                .append("intervalId", intervalId)
                .append("firstTradeId", firstTradeId)
                .append("lastTradeId", lastTradeId)
                .append("quoteAssetVolume", quoteAssetVolume)
                .append("numberOfTrades", numberOfTrades)
                .append("takerBuyBaseAssetVolume", takerBuyBaseAssetVolume)
                .append("takerBuyQuoteAssetVolume", takerBuyQuoteAssetVolume)
                .append("isBarFinal", barFinal)
                .toString()
    }
}