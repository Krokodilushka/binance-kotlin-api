package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.BinanceApiSpotRestClient
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType

class RestSpotEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance(
                args.getOrElse(0) { "API_KEY" },
                args.getOrElse(1) { "API_SECRET" }
            )
            val client: BinanceApiSpotRestClient = factory.newSpotRestClient()
            /*
                        client.account().let {
                            println("binance headers: " + it.headers().toMultimap().filter { it.key.startsWith("x-mbx") })
                            println("body: " + it.body()!!)
                        }

                        client.newOrderTest(
                            "BTCUSDT",
                            OrderSide.BUY,
                            OrderType.LIMIT,
                            OrderTimeInForce.GTC,
                            "0.01",
                            null,
                            "30000",
                            null,
                            null,
                            null
                        ).let {
                            println("newOrderTest: ${it.body()}")
                        }

                        client.newOrder(
                            "BTCUSDT",
                            OrderSide.SELL,
                            OrderType.LIMIT,
                            OrderTimeInForce.GTC,
                            "0.001",
                            null,
                            "100000",
                            null,
                            null,
                            null
                        ).let {
                            return@let it.body()!!
                        }.let {
                            println("newOrder: $it")
                            Thread.sleep(1000L)
                            client.order(it.symbol, it.orderId, null).let {
                                println("order: ${it.body()!!}")
                                println("headers: ${it.headers().toMultimap().filter { it.key.startsWith("x-mbx") }}")
                            }
                            client.openOrders(it.symbol).let {
                                println("openOrders: ${it.body()!!}")
                                println("headers: ${it.headers().toMultimap().filter { it.key.startsWith("x-mbx") }}")
                            }
                            client.allOrders(it.symbol, null, null, null, 5).let {
                                println("allOrders: ${it.body()!!}")
                                println("headers: ${it.headers().toMultimap().filter { it.key.startsWith("x-mbx") }}")
                            }
                            client.cancelOrder(it.symbol, it.orderId, null, null).let {
                                println("cancelOrder: ${it.body()!!}")
                                println("headers: ${it.headers().toMultimap().filter { it.key.startsWith("x-mbx") }}")
                            }
                            client.cancelOpenOrders(it.symbol).let {
                                println("cancelOpenOrders: ${it.body()!!}")
                                println("headers: ${it.headers().toMultimap().filter { it.key.startsWith("x-mbx") }}")
                            }
                            client.myTrades(it.symbol, null, null, null, null).let {
                                println("myTrades: ${it.body()!!}")
                                println("headers: ${it.headers().toMultimap().filter { it.key.startsWith("x-mbx") }}")
                            }
                        }

                        client.newOcoOrder(
                            "XRPBTC",
                            null,
                            OrderSide.BUY,
                            "5",
                            null,
                            "0.00002",
                            null,
                            null,
                            "0.000026",
                            "0.000026",
                            null,
                            OrderTimeInForce.GTC
                        ).let {
                            return@let it.body()!!
                        }.let {
                            println("newOcoOrder: $it")
                            Thread.sleep(1000L)
                            client.ocoOrder(it.orderListId, null).let {
                                println("ocoOrder: $it")
                            }
                            client.allOcoOrders(null, null, null, null).let {
                                println("allOcoOrders: $it")
                            }
                            client.allOpenOcoOrders().let {
                                println("allOpenOcoOrders: $it")
                            }
                            client.cancelOcoOrder("XRPBTC", it.orderListId, null, null).let {
                                println("cancelOcoOrder: $it")
                            }
                        }
            client.walletDepositAddress("BTC", "BNB").body()!!.also {
                println(it)
            }
            */
//            client.walletDepositAddress("BTC", "BNB").body()!!.also {
//                println(it)
//            }
//            client.walletAllCoinsInformation().body()!!.forEach {
//                println(it)
//            }
            client.depositHistory().body()!!.forEach {
                println(it)
            }
        }
    }
}