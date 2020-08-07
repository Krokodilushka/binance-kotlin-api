package com.binance.api.client.domain.event

import com.binance.api.client.constant.BinanceApiConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AllMarketTickersEvent {
    @JsonProperty("e")
    var eventType: String? = null

    @JsonProperty("E")
    var eventTime: Long = 0

    @JsonProperty("s")
    var symbol: String? = null

    @JsonProperty("p")
    var priceChange: String? = null

    @JsonProperty("P")
    var priceChangePercent: String? = null

    @JsonProperty("w")
    var weightedAveragePrice: String? = null

    @JsonProperty("x")
    var previousDaysClosePrice: String? = null

    @JsonProperty("c")
    var currentDaysClosePrice: String? = null

    @JsonProperty("Q")
    var closeTradesQuantity: String? = null

    @JsonProperty("b")
    var bestBidPrice: String? = null

    @JsonProperty("B")
    var bestBidQuantity: String? = null

    @JsonProperty("a")
    var bestAskPrice: String? = null

    @JsonProperty("A")
    var bestAskQuantity: String? = null

    @JsonProperty("o")
    var openPrice: String? = null

    @JsonProperty("h")
    var highPrice: String? = null

    @JsonProperty("l")
    var lowPrice: String? = null

    @JsonProperty("v")
    var totalTradedBaseAssetVolume: String? = null

    @JsonProperty("q")
    var totalTradedQuoteAssetVolume: String? = null

    @JsonProperty("O")
    var statisticesOpenTime: Long = 0

    @JsonProperty("C")
    var statisticesCloseTime: Long = 0

    @JsonProperty("F")
    var firstTradeId: Long = 0

    @JsonProperty("L")
    var lastTradeId: Long = 0

    @JsonProperty("n")
    var totalNumberOfTrades: Long = 0

    override fun toString(): String {
        return ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("eventType", eventType)
                .append("eventTime", eventTime)
                .append("symbol", symbol)
                .append("priceChange", priceChange)
                .append("priceChangePercent", priceChangePercent)
                .append("weightedAveragePrice", weightedAveragePrice)
                .append("previousDaysClosePrice", previousDaysClosePrice)
                .append("currentDaysClosePrice", currentDaysClosePrice)
                .append("closeTradesQuantity", closeTradesQuantity)
                .append("bestBidPrice", bestBidPrice)
                .append("bestBidQuantity", bestBidQuantity)
                .append("bestAskPrice", bestAskPrice)
                .append("bestAskQuantity", bestAskQuantity)
                .append("openPrice", openPrice)
                .append("highPrice", highPrice)
                .append("lowPrice", lowPrice)
                .append("totalTradedBaseAssetVolume", totalTradedBaseAssetVolume)
                .append("totalTradedQuoteAssetVolume", totalTradedQuoteAssetVolume)
                .append("statisticesOpenTime", statisticesOpenTime)
                .append("statisticesCloseTime", statisticesCloseTime)
                .append("firstTradeId", firstTradeId)
                .append("lastTradeId", lastTradeId)
                .append("totalNumberOfTrades", totalNumberOfTrades)
                .toString()
    }
}