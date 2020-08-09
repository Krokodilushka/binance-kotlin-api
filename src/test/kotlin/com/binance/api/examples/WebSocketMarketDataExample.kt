package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.BinanceWebSocketClient
import com.binance.api.client.domain.websocket.MarketEvent

/**
 * Market data stream endpoints examples.
 *
 * It illustrates how to create a stream to obtain updates on market data such as executed trades.
 */
class WebSocketMarketDataExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val client = newInstance().newWebSocketClient()

//            client.onAggTradeEvent("btcusdt", object : BinanceWebSocketClient.WebSocketCallback<MarketEvent.AggTradeEvent> {
//                override fun onResponse(response: MarketEvent.AggTradeEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

            client.onTradeEvent("btcusdt", object : BinanceWebSocketClient.WebSocketCallback<MarketEvent.TradeEvent> {
                override fun onResponse(response: MarketEvent.TradeEvent) {
                    println(response)
                }

                override fun onFailure(cause: Throwable) {
                    println(cause)
                }
            })

//            client.onCandlestickEvent("ethbtc", CandlestickInterval.ONE_MINUTE, object : BinanceWebSocketClient.WebSocketCallback<MarketEvent.CandlestickEvent> {
//                override fun onResponse(response: MarketEvent.CandlestickEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onIndividualSymbolMiniTickerEvent("ethbtc", object : BinanceWebSocketClient.WebSocketCallback<MarketEvent.IndividualSymbolMiniTickerEvent> {
//                override fun onResponse(response: MarketEvent.IndividualSymbolMiniTickerEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onAllMarketTickersEvent(object : BinanceWebSocketClient.WebSocketCallback<List<MarketEvent.AllMarketTickersEvent>> {
//                override fun onResponse(response: List<MarketEvent.AllMarketTickersEvent>) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onAllMarketMiniTickersEvent(object : BinanceWebSocketClient.WebSocketCallback<List<MarketEvent.IndividualSymbolMiniTickerEvent>> {
//                override fun onResponse(response: List<MarketEvent.IndividualSymbolMiniTickerEvent>) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onIndividualSymbolTickerEvent("btcusdt", object : BinanceWebSocketClient.WebSocketCallback<MarketEvent.IndividualSymbolTickerEvent> {
//                override fun onResponse(response: MarketEvent.IndividualSymbolTickerEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onIndividualSymbolBookTickerEvent("btcusdt", object : BinanceWebSocketClient.WebSocketCallback<MarketEvent.IndividualSymbolBookTickerEvent> {
//                override fun onResponse(response: MarketEvent.IndividualSymbolBookTickerEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onAllBookTickersEvent(object : BinanceWebSocketClient.WebSocketCallback<MarketEvent.IndividualSymbolBookTickerEvent> {
//                override fun onResponse(response: MarketEvent.IndividualSymbolBookTickerEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onPartialBookDepthEvent("btcusdt", 5, object : BinanceWebSocketClient.WebSocketCallback<MarketEvent.PartialBookDepth> {
//                override fun onResponse(response: MarketEvent.PartialBookDepth) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onDiffDepthEvent("btcusdt", object : BinanceWebSocketClient.WebSocketCallback<MarketEvent.DepthEvent> {
//                override fun onResponse(response: MarketEvent.DepthEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })
        }
    }
}