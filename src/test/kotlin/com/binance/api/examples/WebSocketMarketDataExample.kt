package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance

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

//            client.onAggTradeEvent("ethbtc", object : WebSocketCallback<MarketEvent.AggTradeEvent> {
//                override fun onResponse(response: MarketEvent.AggTradeEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onTradeEvent("ethbtc", object : WebSocketCallback<MarketEvent.TradeEvent> {
//                override fun onResponse(response: MarketEvent.TradeEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onCandlestickEvent("ethbtc", CandlestickInterval.ONE_MINUTE, object : WebSocketCallback<MarketEvent.CandlestickEvent> {
//                override fun onResponse(response: MarketEvent.CandlestickEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onIndividualSymbolMiniTickerEvent("ethbtc", object : WebSocketCallback<MarketEvent.IndividualSymbolMiniTickerEvent> {
//                override fun onResponse(response: MarketEvent.IndividualSymbolMiniTickerEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })


//            client.onAllMarketTickersEvent(object : WebSocketCallback<List<MarketEvent.AllMarketTickersEvent>> {
//                override fun onResponse(response: List<MarketEvent.AllMarketTickersEvent>) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onAllMarketMiniTickersEvent(object : WebSocketCallback<List<MarketEvent.IndividualSymbolMiniTickerEvent>> {
//                override fun onResponse(response: List<MarketEvent.IndividualSymbolMiniTickerEvent>) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onIndividualSymbolTickerEvent("ethbtc", object : WebSocketCallback<MarketEvent.IndividualSymbolTickerEvent> {
//                override fun onResponse(response: MarketEvent.IndividualSymbolTickerEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onIndividualSymbolBookTickerEvent("btcusdt", object : WebSocketCallback<MarketEvent.IndividualSymbolBookTickerEvent> {
//                override fun onResponse(response: MarketEvent.IndividualSymbolBookTickerEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onAllBookTickersEvent(object : WebSocketCallback<MarketEvent.IndividualSymbolBookTickerEvent> {
//                override fun onResponse(response: MarketEvent.IndividualSymbolBookTickerEvent) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onPartialBookDepthEvent("btcusdt", 5, object : WebSocketCallback<MarketEvent.PartialBookDepth> {
//                override fun onResponse(response: MarketEvent.PartialBookDepth) {
//                    println(response)
//                }
//
//                override fun onFailure(cause: Throwable) {
//                    println(cause)
//                }
//            })

//            client.onDiffDepthEvent("ethbtc", object : WebSocketCallback<MarketEvent.DepthEvent> {
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