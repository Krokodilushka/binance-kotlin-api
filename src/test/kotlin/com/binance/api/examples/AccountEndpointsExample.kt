package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance

/**
 * Examples on how to get account information.
 */
class AccountEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance("YOUR_API_KEY", "YOUR_SECRET")
            val client = factory.newRestClient()

            // Get account balances
            val account = client.getAccount(60000L, System.currentTimeMillis())
            println(account.balances)
            println(account.getAssetBalance("ETH"))

            // Get list of trades
            val myTrades = client.getMyTrades("NEOETH")
            println(myTrades)

            // Get withdraw history
            println(client.getWithdrawHistory("ETH"))

            // Get deposit history
            println(client.getDepositHistory("ETH"))

            // Get deposit address
            println(client.getDepositAddress("ETH"))

            // Withdraw
            client.withdraw("ETH", "0x123", "0.1", null, null)
        }
    }
}