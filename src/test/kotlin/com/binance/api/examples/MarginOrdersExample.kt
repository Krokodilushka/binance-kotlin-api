package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.TimeInForce
import com.binance.api.client.domain.account.NewOrder.Companion.limitBuy
import com.binance.api.client.domain.account.NewOrderResponseType
import com.binance.api.client.domain.account.request.CancelOrderRequest
import com.binance.api.client.domain.account.request.OrderRequest
import com.binance.api.client.domain.account.request.OrderStatusRequest
import com.binance.api.client.exception.BinanceApiException

/**
 * Examples on how to place orders, cancel them, and query account information.
 */
class MarginOrdersExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance("YOUR_API_KEY", "YOUR_SECRET")
            val client = factory.newMarginRestClient()

            // Getting list of open orders
            val openOrders = client.getOpenOrders(OrderRequest("LINKETH"))
            println(openOrders)

            // Get status of a particular order
            val order = client.getOrderStatus(OrderStatusRequest("LINKETH", 751698L))
            println(order)

            // Canceling an order
            try {
                val cancelOrderResponse = client.cancelOrder(CancelOrderRequest("LINKETH", 756762L))
                println(cancelOrderResponse)
            } catch (e: BinanceApiException) {
                println(e.error!!.msg)
            }

            // Placing a real LIMIT order
            val newOrderResponse = client.newOrder(limitBuy("LINKETH", TimeInForce.GTC, "1000", "0.0001").newOrderRespType(NewOrderResponseType.FULL))
            println(newOrderResponse)
        }
    }
}