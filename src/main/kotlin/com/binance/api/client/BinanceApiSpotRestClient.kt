package com.binance.api.client

import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.spot.CancelOrder
import com.binance.api.client.domain.rest.spot.NewOrder

interface BinanceApiSpotRestClient {

    fun newOrderTest(
            symbol: String,
            side: OrderSide,
            type: OrderType,
            timeInForce: OrderTimeInForce?,
            quantity: String?,
            quoteOrderQty: String?,
            price: String?,
            newClientOrderId: String?,
            stopPrice: String?,
            icebergQty: String?
    ): Empty

    fun newOrder(
            symbol: String,
            side: OrderSide,
            type: OrderType,
            timeInForce: OrderTimeInForce?,
            quantity: String?,
            quoteOrderQty: String?,
            price: String?,
            newClientOrderId: String?,
            stopPrice: String?,
            icebergQty: String?
    ): NewOrder

    fun cancelOrder(
            symbol: String,
            orderId: Long?,
            origClientOrderId: String?,
            newClientOrderId: String?
    ): CancelOrder

    fun cancelOpenOrders(
            symbol: String
    ): List<CancelOrder>

    fun order(
            symbol: String,
            orderId: Long?,
            origClientOrderId: String?
    ): com.binance.api.client.domain.rest.spot.Order

    fun openOrders(
            symbol: String?
    ): List<com.binance.api.client.domain.rest.spot.Order>

    fun allOrders(
            symbol: String,
            orderId: Long?,
            startTime: Long?,
            endTime: Long?,
            limit: Int?
    ): List<com.binance.api.client.domain.rest.spot.Order>

    fun newOcoOrder(
            symbol: String,
            listClientOrderId: String?,
            side: OrderSide,
            quantity: String,
            limitClientOrderId: String?,
            price: String,
            limitIcebergQty: String?,
            stopClientOrderId: String?,
            stopPrice: String,
            stopLimitPrice: String?,
            stopIcebergQty: String?,
            stopLimitTimeInForce: OrderTimeInForce?
    ): com.binance.api.client.domain.rest.spot.NewOcoOrder

    fun cancelOcoOrder(
            symbol: String,
            orderListId: Long?,
            listClientOrderId: String?,
            newClientOrderId: String?
    ): com.binance.api.client.domain.rest.spot.CancelOcoOrder

    fun ocoOrder(
            orderListId: Long?,
            origClientOrderId: Long?
    ): com.binance.api.client.domain.rest.spot.OcoOrder

    fun allOcoOrders(
            fromId: String?,
            startTime: Long?,
            endTime: Long?,
            limit: Int?
    ): List<com.binance.api.client.domain.rest.spot.OcoOrder>

    fun allOpenOcoOrders(): List<com.binance.api.client.domain.rest.spot.OcoOrder>

    fun account(): com.binance.api.client.domain.rest.spot.Account

    fun myTrades(
            symbol: String,
            startTime: Long?,
            endTime: Long?,
            fromId: Long?,
            limit: Int?
    ): List<com.binance.api.client.domain.rest.spot.Trade>

    fun startUserDataStream(): String

    fun keepAliveUserDataStream(listenKey: String)

    fun closeUserDataStream(listenKey: String)
}