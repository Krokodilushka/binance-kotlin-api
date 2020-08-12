package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.BinanceWebSocketClient
import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.websocket.WebSocketEvent
import com.binance.api.client.domain.websocket.WebSocketStream
import com.binance.api.client.impl.BinanceApiWebSocketListener


class WebSocketMarketDataExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val callback = object : BinanceWebSocketClient.WebSocketCallback {
                override fun onEvent(eventWrapper: WebSocketEvent.Wrapper<WebSocketEvent>) {
                    println("onEvent: $eventWrapper")
                    when (eventWrapper.event) {
                        is WebSocketEvent.MarketEvent.TradeEvent -> println("^ TradeEvent")
                        is WebSocketEvent.MarketEvent.CandlestickEvent -> println("^ CandlestickEvent")
                        is WebSocketEvent.MarketEvent -> println("^ MarketEvent")
                    }
                }

                override fun onFailure(cause: Throwable) {
                    println("onFailure: $cause")
                    throw cause
                }

                override fun onClosing(code: Int, reason: String) {
                    println("onClosing code: $code, reason: $reason")
                }
            }
            val webSocketListener = BinanceApiWebSocketListener(callback)

            val binanceApiClientFactory = newInstance()
            val webSocketClient = binanceApiClientFactory.newWebSocketClient(webSocketListener)
            val channels = listOf<WebSocketStream>(
//                    WebSocketStream.AggTradeEvent("btcusdt")
//                    WebSocketStream.Trade("wavesusdt"),
                    WebSocketStream.Candlestick("btcusdt", CandlestickInterval.ONE_MINUTE),
//                    WebSocketStream.IndividualSymbolMiniTicker("btcusdt"),
//                    WebSocketStream.AllMarketMiniTickers(),
                    WebSocketStream.IndividualSymbolTickerTicker("btcusdt")
//                    WebSocketStream.AllMarketTickers()
//                    WebSocketStream.IndividualSymbolBookTicker("btcusdt")
//                    WebSocketStream.AllBookTickers()
//                    WebSocketStream.PartialBookDepth("btcusdt", WebSocketStream.PartialBookDepth.Levels.L5, WebSocketStream.PartialBookDepth.UpdateSpeed.MS1000)
//                    WebSocketStream.DiffDepth("btcusdt", WebSocketStream.DiffDepth.UpdateSpeed.MS100)
            )
            webSocketClient.connect(channels)
            println("Wait events...")
        }
    }
}