package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance

/**
 * Examples on how to get margin account information.
 */
class RestMarginEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance(args[0], args[1])
            val client = factory.newMarginRestClient()

//            val marginAccount = client.newCrossTransfer("BTC", "0.00001", 2)
//            println(marginAccount)

//            val newLoan = client.newLoan("BTC", null, null, "0.00001")
//            println(newLoan)

//            val openOrders = client.openOrders(null, null)
//            println(openOrders)

//            val allOrders = client.allOrders("EOSBTC", null, null, null, null, 1)
//            println(allOrders)

//            val myTrades = client.myTrades("EOSBTC", null, null, null, null, 5)
//            println(myTrades)

//            val maxBorrowable = client.maxBorrowable("BTC", "RENBTC")
//            println(maxBorrowable)

//            val maxTransferable = client.maxTransferable("BTC", "RENBTC")
//            println(maxTransferable)

//            val newIsolatedTransfer = client.newIsolatedTransfer("BTC", "RENBTC", TransactionTarget.ISOLATED_MARGIN, TransactionTarget.SPOT, "0.00001")
//            println(newIsolatedTransfer)

//            val isolatedTransfer = client.isolatedTransfer(null, "RENBTC", TransactionTarget.ISOLATED_MARGIN, TransactionTarget.SPOT, null, null, null, null)
//            println(isolatedTransfer)

//            val isolatedAccount = client.isolatedAccount()
//            println(isolatedAccount)

//            val isolatedPair = client.isolatedPair("RENBTC")
//            println(isolatedPair)

            val isolatedAllPairs = client.isolatedAllPairs()
            println(isolatedAllPairs)
        }
    }
}