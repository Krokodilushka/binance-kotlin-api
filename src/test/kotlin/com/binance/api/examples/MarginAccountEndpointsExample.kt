package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.account.MarginAccount

/**
 * Examples on how to get margin account information.
 */
class MarginAccountEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance("YOUR_API_KEY", "YOUR_SECRET")
            val client = factory.newMarginRestClient()

            // Get account balances
            val marginAccount: MarginAccount = client.getAccount()
            println(marginAccount.userAssets)
            println(marginAccount.getAssetBalance("ETH"))
            println(marginAccount.marginLevel)

            // Get list of trades
            val myTrades = client.getMyTrades("NEOETH")
            println(myTrades)
        }
    }
}