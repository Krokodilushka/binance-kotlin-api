package com.binance.api.client.domain.websocket

import com.binance.api.client.domain.websocket.deserializer.OrderBookEntryDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

sealed class MarketEvent {

    //    @JsonIgnoreProperties(ignoreUnknown = true)
    data class AllMarketTickersEvent(
            @JsonProperty("e")
            val eventType: String,
            @JsonProperty("E")
            val eventTime: Long,
            @JsonProperty("s")
            val symbol: String,
            @JsonProperty("p")
            val priceChange: String,
            @JsonProperty("P")
            val priceChangePercent: String,
            @JsonProperty("w")
            val weightedAveragePrice: String,
            @JsonProperty("x")
            val previousDaysClosePrice: String,
            @JsonProperty("c")
            val currentDaysClosePrice: String,
            @JsonProperty("Q")
            val closeTradesQuantity: String,
            @JsonProperty("b")
            val bestBidPrice: String,
            @JsonProperty("B")
            val bestBidQuantity: String,
            @JsonProperty("a")
            val bestAskPrice: String,
            @JsonProperty("A")
            val bestAskQuantity: String,
            @JsonProperty("o")
            val openPrice: String,
            @JsonProperty("h")
            val highPrice: String,
            @JsonProperty("l")
            val lowPrice: String,
            @JsonProperty("v")
            val totalTradedBaseAssetVolume: String,
            @JsonProperty("q")
            val totalTradedQuoteAssetVolume: String,
            @JsonProperty("O")
            val statisticsOpenTime: Long,
            @JsonProperty("C")
            val statisticsCloseTime: Long,
            @JsonProperty("F")
            val firstTradeId: Long,
            @JsonProperty("L")
            val lastTradeId: Long,
            @JsonProperty("n")
            val totalNumberOfTrades: Long
    ) : MarketEvent()

    data class TradeEvent(
            @JsonProperty("e")
            val eventType: String,
            @JsonProperty("E")
            val eventTime: Long,
            @JsonProperty("s")
            val symbol: String,
            @JsonProperty("t")
            val tradeId: Long,
            @JsonProperty("p")
            val price: String,
            @JsonProperty("q")
            val quantity: String,
            @JsonProperty("b")
            val buyerOrderId: Long,
            @JsonProperty("a")
            val sellerOrderId: Long,
            @JsonProperty("T")
            val tradeTime: Long,
            @JsonProperty("m")
            val isTheBuyerTheMarketMaker: Boolean,
            @JsonProperty("M")
            val M: Boolean
    )


    //    @JsonIgnoreProperties(ignoreUnknown = true)
    data class CandlestickEvent(
            @JsonProperty("e")
            val eventType: String,
            @JsonProperty("E")
            val eventTime: Long,
            @JsonProperty("s")
            val symbol: String,
            @JsonProperty("k")
            val candle: Candle

    ) : MarketEvent() {
        data class Candle(
                @JsonProperty("t")
                val openTime: Long,
                @JsonProperty("T")
                val closeTime: Long,
                @JsonProperty("s")
                val symbol: String,
                @JsonProperty("i")
                val interval: String,
                @JsonProperty("f")
                val firstTradeId: Long,
                @JsonProperty("L")
                val lastTradeId: Long,
                @JsonProperty("o")
                val open: String,
                @JsonProperty("c")
                val close: String,
                @JsonProperty("h")
                val high: String,
                @JsonProperty("l")
                val low: String,
                @JsonProperty("v")
                val baseAssetVolume: String,
                @JsonProperty("n")
                val numberOfTrades: Long,
                @JsonProperty("x")
                val isClosed: Boolean,
                @JsonProperty("q")
                val quoteAssetVolume: String,
                @JsonProperty("V")
                val takerBuyBaseAssetVolume: String,
                @JsonProperty("Q")
                val takerBuyQuoteAssetVolume: String,
                @JsonProperty("B")
                val b: String
        )
    }

    //    @JsonIgnoreProperties(ignoreUnknown = true)
    data class IndividualSymbolMiniTickerEvent(
            @JsonProperty("e")
            val eventType: String,
            @JsonProperty("E")
            val eventTime: Long,
            @JsonProperty("s")
            val symbol: String,
            @JsonProperty("c")
            val closePrice: String,
            @JsonProperty("o")
            val openPrice: String,
            @JsonProperty("h")
            val highPrice: String,
            @JsonProperty("l")
            val lowPrice: String,
            @JsonProperty("v")
            val totalTradedBaseAssetVolume: String,
            @JsonProperty("q")
            val totalTradedQuoteAssetVolume: String
    )

    //    @JsonIgnoreProperties(ignoreUnknown = true)
    data class IndividualSymbolTickerEvent(
            @JsonProperty("e")
            val eventType: String,
            @JsonProperty("E")
            val eventTime: Long,
            @JsonProperty("s")
            val symbol: String,
            @JsonProperty("p")
            val priceChange: String,
            @JsonProperty("P")
            val priceChangePercent: String,
            @JsonProperty("w")
            val weightedAveragePrice: String,
            @JsonProperty("x")
            val firstTrade: String,
            @JsonProperty("c")
            val lastPrice: String,
            @JsonProperty("Q")
            val lastQuantity: String,
            @JsonProperty("b")
            val bestBidPrice: String,
            @JsonProperty("B")
            val bestBidQuantity: String,
            @JsonProperty("a")
            val bestAskPrice: String,
            @JsonProperty("A")
            val bestAskQuantity: String,
            @JsonProperty("o")
            val openPrice: String,
            @JsonProperty("h")
            val highPrice: String,
            @JsonProperty("l")
            val lowPrice: String,
            @JsonProperty("v")
            val totalTradedBaseAssetVolume: String,
            @JsonProperty("q")
            val totalTradedQuoteAssetVolume: String,
            @JsonProperty("O")
            val statisticsOpenTime: Long,
            @JsonProperty("C")
            val statisticsCloseTime: Long,
            @JsonProperty("F")
            val firstTradeId: Long,
            @JsonProperty("L")
            val lastTradeId: Long,
            @JsonProperty("n")
            val totalNumberOfTrades: Long
    )

    //    @JsonIgnoreProperties(ignoreUnknown = true)
    data class IndividualSymbolBookTickerEvent(
            @JsonProperty("u")
            val updateId: Long,
            @JsonProperty("s")
            val symbol: String,
            @JsonProperty("b")
            val bestBidPrice: String,
            @JsonProperty("B")
            val bestBidQty: String,
            @JsonProperty("a")
            val bestAskPrice: String,
            @JsonProperty("A")
            val bestAskQty: String
    )

    //    @JsonIgnoreProperties(ignoreUnknown = true)
    data class PartialBookDepth(
            @JsonProperty("lastUpdateId")
            val lastUpdateId: Long,
            @JsonProperty("bids")
            val bids: List<DepthEvent.OrderBookEntry>,
            @JsonProperty("asks")
            val asks: List<DepthEvent.OrderBookEntry>
    )

    //    @JsonIgnoreProperties(ignoreUnknown = true)
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
    ) : MarketEvent() {
        @JsonDeserialize(using = OrderBookEntryDeserializer::class)
        @JsonIgnoreProperties(ignoreUnknown = true)
        data class OrderBookEntry(
                val price: String,
                val qty: String
        )
    }

    //    @JsonIgnoreProperties(ignoreUnknown = true)
    data class AggTradeEvent(
            @JsonProperty("e")
            val eventType: String,
            @JsonProperty("E")
            val eventTime: Long,
            @JsonProperty("s")
            val symbol: String,
            @JsonProperty("a")
            val aggregatedTradeId: Long,
            @JsonProperty("p")
            val price: String,
            @JsonProperty("q")
            val quantity: String,
            @JsonProperty("f")
            val firstBreakdownTradeId: Long,
            @JsonProperty("l")
            val lastBreakdownTradeId: Long,
            @JsonProperty("T")
            val tradeTime: Long,
            @JsonProperty("m")
            val isBuyerMaker: Boolean,
            @JsonProperty("M")
            val M: Boolean
    ) : MarketEvent()
}