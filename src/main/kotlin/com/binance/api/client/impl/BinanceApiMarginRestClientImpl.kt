package com.binance.api.client.impl

import com.binance.api.client.BinanceApiMarginRestClient
import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.account.*
import com.binance.api.client.domain.account.request.CancelOrderRequest
import com.binance.api.client.domain.account.request.CancelOrderResponse
import com.binance.api.client.domain.account.request.OrderRequest
import com.binance.api.client.domain.account.request.OrderStatusRequest

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 */
class BinanceApiMarginRestClientImpl(apiKey: String?, secret: String?) : BinanceApiMarginRestClient {

    private val binanceApiService = BinanceApiServiceGenerator.createService(BinanceApiService::class.java, apiKey, secret)

    override fun getAccount() = BinanceApiServiceGenerator.executeSync(binanceApiService.getMarginAccount(BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun getOpenOrders(orderRequest: OrderRequest): List<Order> {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.getOpenMarginOrders(orderRequest.symbol, orderRequest.recvWindow,
                orderRequest.timestamp))
    }

    override fun newOrder(order: NewOrder): NewOrderResponse {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.newMarginOrder(order.symbol, order.side, order.type,
                order.timeInForce, order.quantity, order.price, order.newClientOrderId, order.stopPrice,
                order.icebergQty, order.newOrderRespType, order.recvWindow, order.timestamp))
    }

    override fun cancelOrder(cancelOrderRequest: CancelOrderRequest): CancelOrderResponse {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.cancelMarginOrder(cancelOrderRequest.symbol,
                cancelOrderRequest.orderId, cancelOrderRequest.origClientOrderId, cancelOrderRequest.newClientOrderId,
                cancelOrderRequest.recvWindow, cancelOrderRequest.timestamp))
    }

    override fun getOrderStatus(orderStatusRequest: OrderStatusRequest): Order? {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.getMarginOrderStatus(orderStatusRequest.symbol,
                orderStatusRequest.orderId, orderStatusRequest.origClientOrderId,
                orderStatusRequest.recvWindow, orderStatusRequest.timestamp))
    }

    override fun getMyTrades(symbol: String?): List<Trade> {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.getMyTrades(symbol, null, null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))
    }

    override fun getAllPairs() = BinanceApiServiceGenerator.executeSync(binanceApiService.allPairs())

    override fun getMaxBorrowable(asset: String?): MaxBorrowable {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.getMaxBorrowable(asset, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))
    }

    override fun newMarginLoan(asset: String?, amount: String?): MarginLoan {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.newMarginLoan(asset, amount, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))
    }

    override fun newMarginRepay(asset: String?, amount: String?): MarginLoan {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.newMarginRepay(asset, amount, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))
    }

    // user stream endpoints
    override fun startUserDataStream(): String {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.startMarginUserDataStream()).listenKey
    }

    override fun keepAliveUserDataStream(listenKey: String?) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.keepAliveMarginUserDataStream(listenKey))
    }

}