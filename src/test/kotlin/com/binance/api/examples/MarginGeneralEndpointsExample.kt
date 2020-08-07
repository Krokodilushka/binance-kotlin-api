package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.general.MarginPair

/**
 * Examples on how to use the general endpoints.
 */
class MarginGeneralEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance("YOUR_API_KEY", "YOUR_SECRET")
            val client = factory.newMarginRestClient()

            // Exchange info
            val marginPairs: List<MarginPair> = client.getAllPairs()
            println(marginPairs)
        }
    }
}