package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.WebSocketCallback
import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.event.AggTradeEvent
import com.binance.api.client.domain.event.CandlestickEvent
import com.binance.api.client.domain.event.DepthEvent

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

            // Listen for aggregated trade events for ETH/BTC
            client.onAggTradeEvent("ethbtc", object : WebSocketCallback<AggTradeEvent> {
                override fun onResponse(response: AggTradeEvent) {
                    println(response)
                }

                override fun onFailure(cause: Throwable) {
                    println(cause)
                }
            })

            // Listen for changes in the order book in ETH/BTC
            client.onDepthEvent("ethbtc", object : WebSocketCallback<DepthEvent> {
                override fun onResponse(response: DepthEvent) {
                    println(response)
                }

                override fun onFailure(cause: Throwable) {
                    println(cause)
                }
            })

            // Obtain 1m candlesticks in real-time for ETH/BTC
            client.onCandlestickEvent("ethbtc", CandlestickInterval.ONE_MINUTE, object : WebSocketCallback<CandlestickEvent> {
                override fun onResponse(response: CandlestickEvent) {
                    println(response)
                }

                override fun onFailure(cause: Throwable) {
                    println(cause)
                }
            })
        }
    }
}