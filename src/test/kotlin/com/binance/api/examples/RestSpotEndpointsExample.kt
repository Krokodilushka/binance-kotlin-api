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

            client.account().let {
                println(it)
            }

            client.newOrderTest(
                "BTCUSDT",
                OrderSide.SELL,
                OrderType.LIMIT,
                OrderTimeInForce.GTC,
                "0.01",
                null,
                "6000",
                null,
                null,
                null
            ).let {
                println("newOrderTest: $it")
            }

            client.newOrder(
                "BTCUSDT",
                OrderSide.SELL,
                OrderType.LIMIT,
                OrderTimeInForce.GTC,
                "0.001",
                null,
                "20000",
                null,
                null,
                null
            ).let {
                println("newOrder: $it")
                client.order(it.symbol, it.orderId, null).let {
                    println("order: $it")
                }
                client.openOrders(it.symbol).let {
                    println("openOrders: $it")
                }
//                client.allOrders(it.symbol, null, null, null, 5).let {
//                    println("allOrders: $it")
//                }
                client.cancelOrder(it.symbol, it.orderId, null, null).let {
                    println("cancelOrder: $it")
                }
                client.cancelOpenOrders(it.symbol).let {
                    println("cancelOpenOrders: $it")
                }
                client.myTrades(it.symbol, null, null, null, null).let {
                    println("myTrades: $it")
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
                println("newOcoOrder: $it")
                client.ocoOrder(it.orderListId, null).let {
                    println("ocoOrder: $it")
                }
//                client.allOcoOrders(null, null, null, null).let {
//                    println("allOcoOrders: $it")
//                }
                client.allOpenOcoOrders().let {
                    println("allOpenOcoOrders: $it")
                }
                client.cancelOcoOrder("XRPBTC", it.orderListId, null, null).let {
                    println("cancelOcoOrder: $it")
                }
            }
        }
    }
}