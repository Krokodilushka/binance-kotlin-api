package com.binance.api.client.domain.websocket

import com.binance.api.client.domain.*
import com.binance.api.client.domain.websocket.deserializer.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

abstract class WebSocketEvent {

    @JsonDeserialize(using = WebSocketEventWraperDeserializer::class)
    data class Wrapper<T : WebSocketEvent>(
            @JsonProperty("stream")
            val stream: String,
            @JsonProperty("data")
            val event: T
    )

    sealed class MarketEvent : WebSocketEvent() {

        @JsonIgnoreProperties(ignoreUnknown = true)
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
        ) : MarketEvent()

        @JsonIgnoreProperties(ignoreUnknown = true)
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
            @JsonIgnoreProperties(ignoreUnknown = true)
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

        @JsonIgnoreProperties(ignoreUnknown = true)
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
        ) : MarketEvent() {
            @JsonDeserialize(using = IndividualSymbolMiniTickerEventListDeserializer::class)
            data class List(val list: kotlin.collections.List<IndividualSymbolMiniTickerEvent>) : WebSocketEvent()
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
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
        ) : MarketEvent() {
            @JsonDeserialize(using = IndividualSymbolTickerEventListDeserializer::class)
            data class List(val list: kotlin.collections.List<IndividualSymbolTickerEvent>) : WebSocketEvent()
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
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
        ) : MarketEvent() {
            @JsonDeserialize(using = IndividualSymbolBookTickerEventListDeserializer::class)
            data class List(val list: kotlin.collections.List<IndividualSymbolBookTickerEvent>) : WebSocketEvent()
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class PartialBookDepth(
                @JsonProperty("lastUpdateId")
                val lastUpdateId: Long,
                @JsonProperty("bids")
                val bids: List<DepthEvent.OrderBookEntry>,
                @JsonProperty("asks")
                val asks: List<DepthEvent.OrderBookEntry>
        ) : MarketEvent()

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
        ) : MarketEvent() {
            @JsonDeserialize(using = OrderBookEntryDeserializer::class)
            @JsonIgnoreProperties(ignoreUnknown = true)
            data class OrderBookEntry(
                    val price: String,
                    val qty: String
            )
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
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


    @JsonDeserialize(using = UserDataUpdateEventDeserializer::class)
    data class UserDataEvent(val event: Event) : WebSocketEvent() {
        abstract class Event : WebSocketEvent() {

            @JsonIgnoreProperties(ignoreUnknown = true)
            data class AccountPosition(
                    @JsonProperty("e")
                    val eventType: String,
                    @JsonProperty("E")
                    val eventTime: Long,
                    @JsonProperty("u")
                    val timeOfLastAccountUpdate: Long,
                    @JsonProperty("B")
                    val balances: List<Balance>
            ) : Event() {
                @JsonIgnoreProperties(ignoreUnknown = true)
                data class Balance(
                        @JsonProperty("a")
                        val asset: String,
                        @JsonProperty("f")
                        val free: String,
                        @JsonProperty("l")
                        val locked: String
                )
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            data class BalanceUpdateEvent(
                    @JsonProperty("e")
                    val eventType: String,
                    @JsonProperty("E")
                    val eventTime: Long,
                    @JsonProperty("a")
                    val asset: String,
                    @JsonProperty("d")
                    val balanceDelta: String,
                    @JsonProperty("T")
                    val clearTime: Long
            ) : Event()

            @JsonIgnoreProperties(ignoreUnknown = true)
            data class OrderTradeUpdateEvent(
                    @JsonProperty("e")
                    val eventType: String,
                    @JsonProperty("E")
                    val eventTime: Long,
                    @JsonProperty("s")
                    val symbol: String,
                    @JsonProperty("c")
                    val clientOrderId: String,
                    @JsonProperty("S")
                    val side: OrderSide,
                    @JsonProperty("o")
                    val orderType: OrderType,
                    @JsonProperty("f")
                    val timeInForce: OrderTimeInForce,
                    @JsonProperty("q")
                    val quantity: String,
                    @JsonProperty("p")
                    val price: String,
                    @JsonProperty("P")
                    val stopPrice: String,
                    @JsonProperty("F")
                    val icebergQuantity: String,
                    @JsonProperty("g")
                    val orderListId: Long,
                    @JsonProperty("C")
                    val originalClientOrderId: String,
                    @JsonProperty("x")
                    val currentExecutionType: ExecutionType,
                    @JsonProperty("X")
                    val currentOrderStatus: OrderStatus,
                    @JsonProperty("r")
                    val orderRejectReason: OrderRejectReason,
                    @JsonProperty("i")
                    val orderId: Long,
                    @JsonProperty("l")
                    val lastExecutedQuantity: String,
                    @JsonProperty("z")
                    val cumulativeFilledQuantity: String,
                    @JsonProperty("L")
                    val lastExecutedPrice: String,
                    @JsonProperty("n")
                    val commissionAmount: String,
                    @JsonProperty("N")
                    val commissionAsset: String?,
                    @JsonProperty("T")
                    val transactionTime: Long,
                    @JsonProperty("t")
                    val tradeId: Long,
                    @JsonProperty("I")
                    val i: Long,
                    @JsonProperty("w")
                    val isTheOrderOnTheBook: Boolean,
                    @JsonProperty("m")
                    val isThisTradeTheMakerSide: Boolean,
                    @JsonProperty("M")
                    val m: Boolean,
                    @JsonProperty("O")
                    val orderCreationTime: Long,
                    @JsonProperty("Z")
                    val cumulativeQuoteAssetTransactedQuantity: String,
                    @JsonProperty("Y")
                    val lastQuoteAssetTransactedQuantity: String,
                    @JsonProperty("Q")
                    val quoteOrderQty: String
            ) : Event()

            @JsonIgnoreProperties(ignoreUnknown = true)
            data class OcoOrderTradeUpdateEvent(
                    @JsonProperty("e")
                    val eventType: String,
                    @JsonProperty("E")
                    val eventTime: Long,
                    @JsonProperty("s")
                    val symbol: String,
                    @JsonProperty("g")
                    val orderListId: Long,
                    @JsonProperty("c")
                    val contingencyType: String,
                    @JsonProperty("l")
                    val listStatusType: String,
                    @JsonProperty("L")
                    val listOrderStatus: String,
                    @JsonProperty("r")
                    val listRejectReason: String,
                    @JsonProperty("C")
                    val listClientOrder: String,
                    @JsonProperty("T")
                    val transactionTime: Long,
                    @JsonProperty("O")
                    val orders: List<Order>
            ) : Event() {
                @JsonIgnoreProperties(ignoreUnknown = true)
                data class Order(
                        @JsonProperty("s")
                        val symbol: String,
                        @JsonProperty("i")
                        val orderId: Long,
                        @JsonProperty("c")
                        val clientOrderId: String
                )
            }
        }
    }
}