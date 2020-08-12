package com.binance.api.client.domain.websocket

import com.binance.api.client.domain.CandlestickInterval

abstract class WebSocketStream {
    data class AggTradeEvent(val symbol: String) : WebSocketStream() {
        override fun toString(): String {
            return "$symbol@aggTrade"
        }
    }

    data class Trade(val symbol: String) : WebSocketStream() {
        override fun toString(): String {
            return "$symbol@trade"
        }
    }

    data class Candlestick(val symbol: String, val interval: CandlestickInterval) : WebSocketStream() {
        override fun toString(): String {
            return "$symbol@kline_${interval.intervalId}"
        }
    }

    data class IndividualSymbolMiniTicker(val symbol: String) : WebSocketStream() {
        override fun toString(): String {
            return "$symbol@miniTicker"
        }
    }

    class AllMarketMiniTickers : WebSocketStream() {
        override fun toString(): String {
            return "!miniTicker@arr"
        }
    }

    data class IndividualSymbolTickerTicker(val symbol: String) : WebSocketStream() {
        override fun toString(): String {
            return "$symbol@ticker"
        }
    }

    class AllMarketTickers : WebSocketStream() {
        override fun toString(): String {
            return "!ticker@arr"
        }
    }

    data class IndividualSymbolBookTicker(val symbol: String) : WebSocketStream() {
        override fun toString(): String {
            return "$symbol@bookTicker"
        }
    }

    class AllBookTickers : WebSocketStream() {
        override fun toString(): String {
            return "!bookTicker"
        }
    }

    data class PartialBookDepth(val symbol: String, val levels: Levels, val updateSpeed: UpdateSpeed) : WebSocketStream() {
        override fun toString(): String {
            return "$symbol@depth${levels.strValue}@${updateSpeed.strValue}"
        }

        enum class Levels(val strValue: String) {
            L5("5"), L10("10"), L20("20")
        }

        enum class UpdateSpeed(val strValue: String) {
            MS1000("1000ms"), MS100("100ms")
        }
    }

    data class DiffDepth(val symbol: String, val updateSpeed: UpdateSpeed) : WebSocketStream() {
        override fun toString(): String {
            return "$symbol@depth@${updateSpeed.strValue}"
        }

        enum class UpdateSpeed(val strValue: String) {
            MS1000("1000ms"), MS100("100ms")
        }
    }

    data class UserData(val listenKey: String) : WebSocketStream() {
        override fun toString(): String {
            return listenKey
        }
    }
}