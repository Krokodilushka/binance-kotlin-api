package com.binance.api.examples

import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.event.AllMarketTickersEvent

/**
 * All market tickers channel examples.
 *
 * It illustrates how to create a stream to obtain all market tickers.
 */
class AllMarketTickersExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance()
            val client = factory.newWebSocketClient()
            client.onAllMarketTickersEvent(object : BinanceApiCallback<List<AllMarketTickersEvent>> {
                override fun onResponse(response: List<AllMarketTickersEvent>) {
                    println(response)
                }
            })
        }
    }
}