package com.binance.api.client.impl

import com.binance.api.client.BinanceApiSpotRestClient
import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.NewOrderResponseType
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.spot.*
import com.binance.api.client.service.BinanceApiServiceGenerator
import com.binance.api.client.service.BinanceApiServiceSpot

/**
 * Implementation of Binance's REST API using Retrofit with synchronous/blocking method calls.
 */
class BinanceApiSpotRestClientImpl(apiKey: String?, secret: String?) : BinanceApiSpotRestClient {

    private val binanceApiService = BinanceApiServiceGenerator.createService(BinanceApiServiceSpot::class.java, apiKey, secret)

    override fun newOrderTest(symbol: String, side: OrderSide, type: OrderType, timeInForce: OrderTimeInForce?, quantity: String?, quoteOrderQty: String?, price: String?, newClientOrderId: String?, stopPrice: String?, icebergQty: String?): Empty = BinanceApiServiceGenerator.executeSync(binanceApiService.newOrderTest(symbol, side, type, timeInForce, quantity, quoteOrderQty, price, newClientOrderId, stopPrice, icebergQty, NewOrderResponseType.FULL, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun newOrder(symbol: String, side: OrderSide, type: OrderType, timeInForce: OrderTimeInForce?, quantity: String?, quoteOrderQty: String?, price: String?, newClientOrderId: String?, stopPrice: String?, icebergQty: String?): NewOrder = BinanceApiServiceGenerator.executeSync(binanceApiService.newOrder(symbol, side, type, timeInForce, quantity, quoteOrderQty, price, newClientOrderId, stopPrice, icebergQty, NewOrderResponseType.FULL, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun cancelOrder(symbol: String, orderId: Long?, origClientOrderId: String?, newClientOrderId: String?): CancelOrder = BinanceApiServiceGenerator.executeSync(binanceApiService.cancelOrder(symbol, orderId, origClientOrderId, newClientOrderId, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun cancelOpenOrders(symbol: String): List<CancelOrder> = BinanceApiServiceGenerator.executeSync(binanceApiService.cancelOpenOrders(symbol, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun order(symbol: String, orderId: Long?, origClientOrderId: String?): Order = BinanceApiServiceGenerator.executeSync(binanceApiService.order(symbol, orderId, origClientOrderId, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun openOrders(symbol: String?): List<Order> = BinanceApiServiceGenerator.executeSync(binanceApiService.openOrders(symbol, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun allOrders(symbol: String, orderId: Long?, startTime: Long?, endTime: Long?, limit: Int?): List<Order> = BinanceApiServiceGenerator.executeSync(binanceApiService.allOrders(symbol, orderId, startTime, endTime, limit, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun newOcoOrder(symbol: String, listClientOrderId: String?, side: OrderSide, quantity: String, limitClientOrderId: String?, price: String, limitIcebergQty: String?, stopClientOrderId: String?, stopPrice: String, stopLimitPrice: String?, stopIcebergQty: String?, stopLimitTimeInForce: OrderTimeInForce?): NewOcoOrder = BinanceApiServiceGenerator.executeSync(binanceApiService.newOcoOrder(symbol, listClientOrderId, side, quantity, limitClientOrderId, price, limitIcebergQty, stopClientOrderId, stopPrice, stopLimitPrice, stopIcebergQty, stopLimitTimeInForce, NewOrderResponseType.FULL, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun cancelOcoOrder(symbol: String, orderListId: Long?, listClientOrderId: String?, newClientOrderId: String?): CancelOcoOrder = BinanceApiServiceGenerator.executeSync(binanceApiService.cancelOcoOrder(symbol, orderListId, listClientOrderId, newClientOrderId, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun ocoOrder(orderListId: Long?, origClientOrderId: Long?): OcoOrder = BinanceApiServiceGenerator.executeSync(binanceApiService.ocoOrder(orderListId, origClientOrderId, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun allOcoOrders(fromId: String?, startTime: Long?, endTime: Long?, limit: Int?): List<OcoOrder> = BinanceApiServiceGenerator.executeSync(binanceApiService.allOcoOrders(fromId, startTime, endTime, limit, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun allOpenOcoOrders(): List<OcoOrder> = BinanceApiServiceGenerator.executeSync(binanceApiService.allOpenOcoOrders(BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun account(): Account = BinanceApiServiceGenerator.executeSync(binanceApiService.account(BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun myTrades(symbol: String, startTime: Long?, endTime: Long?, fromId: Long?, limit: Int?): List<Trade> = BinanceApiServiceGenerator.executeSync(binanceApiService.myTrades(symbol, startTime, endTime, fromId, limit, BinanceApiConstants.SPOT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun startUserDataStream(): String = BinanceApiServiceGenerator.executeSync(binanceApiService.startUserDataStream()).listenKey

    override fun keepAliveUserDataStream(listenKey: String) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.keepAliveUserDataStream(listenKey))
    }

    override fun closeUserDataStream(listenKey: String) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.closeUserDataStream(listenKey))
    }

}