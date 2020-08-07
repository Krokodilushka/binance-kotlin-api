package com.binance.api.client.impl

import com.binance.api.client.BinanceApiRestClient
import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.account.NewOrder
import com.binance.api.client.domain.account.request.AllOrdersRequest
import com.binance.api.client.domain.account.request.CancelOrderRequest
import com.binance.api.client.domain.account.request.OrderRequest
import com.binance.api.client.domain.account.request.OrderStatusRequest
import com.binance.api.client.domain.market.CandlestickInterval

/**
 * Implementation of Binance's REST API using Retrofit with synchronous/blocking method calls.
 */
class BinanceApiRestClientImpl(apiKey: String?, secret: String?) : BinanceApiRestClient {
    private val binanceApiService = BinanceApiServiceGenerator.createService(BinanceApiService::class.java, apiKey, secret)

    // General endpoints
    override fun ping() {
        BinanceApiServiceGenerator.executeSync(binanceApiService.ping())
    }

    override fun getServerTime() = BinanceApiServiceGenerator.executeSync(binanceApiService.getServerTime()).serverTime

    override fun getExchangeInfo() = BinanceApiServiceGenerator.executeSync(binanceApiService.getExchangeInfo())

    override fun getAllAssets() = BinanceApiServiceGenerator.executeSync(binanceApiService.getAllAssets(BinanceApiConstants.ASSET_INFO_API_BASE_URL + "assetWithdraw/getAllAsset.html"))

    // Market Data endpoints
    override fun getOrderBook(symbol: String?, limit: Int?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getOrderBook(symbol, limit))


    override fun getTrades(symbol: String?, limit: Int?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getTrades(symbol, limit))


    override fun getHistoricalTrades(symbol: String?, limit: Int?, fromId: Long?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getHistoricalTrades(symbol, limit, fromId))


    override fun getAggTrades(symbol: String?, fromId: String?, limit: Int?, startTime: Long?, endTime: Long?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getAggTrades(symbol, fromId, limit, startTime, endTime))


    override fun getAggTrades(symbol: String?) = getAggTrades(symbol, null, null, null, null)


    override fun getCandlestickBars(symbol: String?, interval: CandlestickInterval, limit: Int?, startTime: Long?, endTime: Long?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getCandlestickBars(symbol, interval.intervalId, limit, startTime, endTime))


    override fun getCandlestickBars(symbol: String?, interval: CandlestickInterval) = getCandlestickBars(symbol, interval, null, null, null)


    override fun get24HrPriceStatistics(symbol: String) = getAll24HrPriceStatistics().find { it.symbol == symbol }!!

    override fun getAll24HrPriceStatistics() = BinanceApiServiceGenerator.executeSync(binanceApiService.get24HrPriceStatistics(null))

    override fun getPrice(symbol: String?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getLatestPrice(symbol))


    override fun getAllPrices() = BinanceApiServiceGenerator.executeSync(binanceApiService.getLatestPrices())

    override fun getBookTickers() = BinanceApiServiceGenerator.executeSync(binanceApiService.getBookTickers())

    override fun newOrder(order: NewOrder) = BinanceApiServiceGenerator.executeSync(binanceApiService.newOrder(order.symbol, order.side, order.type,
            order.timeInForce, order.quantity, order.price, order.newClientOrderId, order.stopPrice,
            order.icebergQty, order.newOrderRespType, order.recvWindow, order.timestamp))


    override fun newOrderTest(order: NewOrder) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.newOrderTest(order.symbol, order.side, order.type,
                order.timeInForce, order.quantity, order.price, order.newClientOrderId, order.stopPrice,
                order.icebergQty, order.newOrderRespType, order.recvWindow, order.timestamp))
    }

    // Account endpoints
    override fun getOrderStatus(orderStatusRequest: OrderStatusRequest) = BinanceApiServiceGenerator.executeSync(binanceApiService.getOrderStatus(orderStatusRequest.symbol,
            orderStatusRequest.orderId, orderStatusRequest.origClientOrderId,
            orderStatusRequest.recvWindow, orderStatusRequest.timestamp))


    override fun cancelOrder(cancelOrderRequest: CancelOrderRequest) = BinanceApiServiceGenerator.executeSync(binanceApiService.cancelOrder(cancelOrderRequest.symbol,
            cancelOrderRequest.orderId, cancelOrderRequest.origClientOrderId, cancelOrderRequest.newClientOrderId,
            cancelOrderRequest.recvWindow, cancelOrderRequest.timestamp))


    override fun getOpenOrders(orderRequest: OrderRequest) = BinanceApiServiceGenerator.executeSync(binanceApiService.getOpenOrders(orderRequest.symbol, orderRequest.recvWindow, orderRequest.timestamp))


    override fun getAllOrders(orderRequest: AllOrdersRequest) = BinanceApiServiceGenerator.executeSync(binanceApiService.getAllOrders(orderRequest.symbol,
            orderRequest.orderId, orderRequest.limit,
            orderRequest.recvWindow, orderRequest.timestamp))


    override fun getAccount(recvWindow: Long?, timestamp: Long?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getAccount(recvWindow, timestamp))


    override fun getAccount() = BinanceApiServiceGenerator.executeSync(binanceApiService.getAccount(BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun getMyTrades(symbol: String?, limit: Int?, fromId: Long?, recvWindow: Long?, timestamp: Long?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getMyTrades(symbol, limit, fromId, recvWindow, timestamp))

    override fun getMyTrades(symbol: String?, limit: Int?) = getMyTrades(symbol, limit, null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis())

    override fun getMyTrades(symbol: String?) = getMyTrades(symbol, null, null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis())

    override fun withdraw(asset: String?, address: String?, amount: String?, name: String?, addressTag: String?) = BinanceApiServiceGenerator.executeSync(binanceApiService.withdraw(asset, address, amount, name, addressTag, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun getDepositHistory(asset: String?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getDepositHistory(asset, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun getWithdrawHistory(asset: String?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getWithdrawHistory(asset, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))

    override fun getDepositAddress(asset: String?) = BinanceApiServiceGenerator.executeSync(binanceApiService.getDepositAddress(asset, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()))

    // User stream endpoints
    override fun startUserDataStream() = BinanceApiServiceGenerator.executeSync(binanceApiService.startUserDataStream()).toString()

    override fun keepAliveUserDataStream(listenKey: String?) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.keepAliveUserDataStream(listenKey))
    }

    override fun closeUserDataStream(listenKey: String?) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.closeAliveUserDataStream(listenKey))
    }
}