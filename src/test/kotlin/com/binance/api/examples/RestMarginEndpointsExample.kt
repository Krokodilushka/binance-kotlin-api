package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.TransactionTarget
import java.time.Instant
import kotlin.system.exitProcess

class RestMarginEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance(
                args.getOrElse(0) { "API_KEY" },
                args.getOrElse(1) { "API_SECRET" }
            )
            val client = factory.newMarginRestClient()

//            client.newCrossTransfer("BTC", "0.00001", 1).let {
//                println("newCrossTransfer btc spot to margin: ${it.body()}")
//                println("binance headers: " + it.headers().toMultimap().filter { it.key.startsWith("x-mbx") })
//                client.newCrossTransfer("BTC", "0.00001", 2).let {
//                    println("newCrossTransfer btc margin to spot: $it")
//                }
//            }
//
//            client.newLoan("BTC", null, null, "0.00001").let {
//                println("newLoan: $it")
//            }
//
//            client.newRepay("BTC", null, null, "0.00001").let {
//                println("newRepay: $it")
//            }
//
//            client.asset("BTC").let {
//                println("asset: $it")
//            }
//
//            client.pair("BTCUSDT").let {
//                println("pair: $it")
//            }
//
//            client.allAssets().let {
//                println("allAssets: ${it.body()}")
//            }
//
//            client.priceIndex("BTCUSDT").let {
//                println("priceIndex: $it")
//            }
//
//            client.priceIndex("BTCUSDT").let {
//                println("priceIndex: $it")
//            }
//
//            client.newOrder(
//                "BTCUSDT",
//                false,
//                OrderSide.SELL,
//                OrderType.LIMIT,
//                "0.01",
//                "20000",
//                null,
//                null,
//                null,
//                null,
//                OrderTimeInForce.GTC
//            ).let {
//                return@let it.body()!!
//            }.let {
//                println("newOrder: $it")
//                client.order(it.symbol, null, it.orderId, null).let {
//                    println("order: $it")
//                }
//                client.openOrders(null, null).let {
//                    println("openOrders: $it")
//                }
//                client.allOrders(it.symbol, null, null, null, null, null).let {
//                    println("allOrders: $it")
//                }
//                client.myTrades(it.symbol, null, null, null, null, null).let {
//                    println("myTrades: $it")
//                }
//                client.cancelOrder("BTCUSDT", null, it.orderId, null, null).let {
//                    println("cancelOrder: $it")
//                }
//            }
//
//            client.cancelOpenOrders("BTCUSDT", null).let {
//                println("cancelOpenOrders: ${it.body()}")
//            }
//
//            client.crossTransfer(null, null, null, null, null, null).let {
//                println("crossTransfer: $it")
//            }
//
//            client.loan("BTC", null, null, Instant.now().minusSeconds(3600 * 24 * 7).epochSecond, null, null, null)
//                .let {
//                    println("loan: $it")
//                }
//
//            client.repay("BTC", null, null, Instant.now().minusSeconds(3600 * 24 * 7).epochSecond, null, null, null)
//                .let {
//                    println("repay: $it")
//                }
//
//            client.interestHistory("BTC", null, null, null, null, null).let {
//                println("interestHistory: $it")
//            }
//
//            client.forceLiquidationRec(null, null, null, null, null).let {
//                println("forceLiquidationRec: $it")
//            }
//
//            client.account().let {
//                return@let it.body()!!
//            }.let {
//                println("borrowEnabled: " + it.borrowEnabled)
//                println("marginLevel: " + it.marginLevel)
//                println("totalAssetOfBtc: " + it.totalAssetOfBtc)
//                println("totalLiabilityOfBtc: " + it.totalLiabilityOfBtc)
//                println("totalNetAssetOfBtc: " + it.totalNetAssetOfBtc)
//                println("tradeEnabled: " + it.tradeEnabled)
//                println("borrowEnabled: " + it.borrowEnabled)
//                println("account: ${it.userAssets.joinToString("\n") { it.toString() }}")
//            }
//
//            client.maxBorrowable("WAN", null).let {
//                println("maxBorrowable: ${it.body()}")
//            }
//
//            client.maxTransferable("BTC", "BNBBTC").let {
//                println("maxTransferable: $it")
//            }
//
//            client.isolatedCreate("XRP", "BTC").let {
//                println("isolatedCreate: ${it.body()}")
//            }
//
//            client.newIsolatedTransfer(
//                "BTC",
//                "RENBTC",
//                TransactionTarget.SPOT,
//                TransactionTarget.ISOLATED_MARGIN,
//                "0.00001"
//            ).let {
//                println("newIsolatedTransfer spot BTC to isolated margin RENBTC: $it")
//                client.newIsolatedTransfer(
//                    "BTC",
//                    "RENBTC",
//                    TransactionTarget.ISOLATED_MARGIN,
//                    TransactionTarget.SPOT,
//                    "0.00001"
//                ).let {
//                    println("newIsolatedTransfer isolated margin BTC to spot RENBTC: $it")
//                }
//            }
//
//            client.isolatedTransfer(
//                null,
//                "RENBTC",
//                TransactionTarget.ISOLATED_MARGIN,
//                TransactionTarget.SPOT,
//                null,
//                null,
//                null,
//                null
//            ).let {
//                println("isolatedTransfer: $it")
//            }
//
//            client.isolatedAccount().let {
//                println("isolatedAccount:${it.body()}")
//            }
//
//            client.isolatedAccount(listOf("XRPBTC", "BTCUSD")).let {
//                println("isolatedAccount:${it.body()}")
//            }
//
//            client.isolatedPair("RENBTC").let {
//                println("isolatedPair: ${it.body()}")
//            }
//
//            client.isolatedAllPairs().let {
//                return@let it.body()!!
//            }.let {
//                println("isolatedAllPairs: ${it.joinToString(separator = "\n") { it.toString() }}")
//            }
//
//            client.bnbBurn(true, true).let {
//                println("bnbBurn: ${it.body()}")
//            }
//
//            client.bnbBurn().let {
//                println("bnbBurn: ${it.body()}")
//            }
//
//            client.interestRateHistory("BTC", null, null, null, null).let {
//                println("interestRateHistory: ${it.body()}")
//            }

//            client.assetsThatCanBeConvertedIntoBNB().body()!!.also {
//                println("dribbletPercentage: ${it.dribbletPercentage}")
//                println("totalTransferBNB: ${it.totalTransferBNB}")
//                println("totalTransferBtc: ${it.totalTransferBtc}")
//                it.details.forEach(::println)
//            }
//
//            client.dustTransfer(listOf("THETA")).let {
//                println("dustTransfer: ${it.body()}")
//            }
//
//            client.allPairs().let {
//                println("allPairs: ${it.body()}")
//            }
        }
    }

}