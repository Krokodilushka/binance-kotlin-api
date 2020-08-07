package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance

/**
 * Examples on how to get account information.
 */
class RestSpotAccountEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance(args[0], args[1])
            val client = factory.newSpotRestClient()

//            val account = client.account()
//            println(account.balances)

            val myTrades = client.myTrades("NEOETH", null, null, null, null)
            println(myTrades)
        }
    }
}