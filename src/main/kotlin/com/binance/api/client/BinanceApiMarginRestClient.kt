package com.binance.api.client

import com.binance.api.client.domain.account.*
import com.binance.api.client.domain.account.request.CancelOrderRequest
import com.binance.api.client.domain.account.request.CancelOrderResponse
import com.binance.api.client.domain.account.request.OrderRequest
import com.binance.api.client.domain.account.request.OrderStatusRequest
import com.binance.api.client.domain.general.MarginPair

interface BinanceApiMarginRestClient {
    /**
     * Get current margin account information using default parameters.
     */
    fun getAccount(): MarginAccount

    /**
     * Get all open orders on margin account for a symbol.
     *
     * @param orderRequest order request parameters
     */
    fun getOpenOrders(orderRequest: OrderRequest): List<Order>

    /**
     * Send in a new margin order.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    fun newOrder(order: NewOrder): NewOrderResponse

    /**
     * Cancel an active margin order.
     *
     * @param cancelOrderRequest order status request parameters
     */
    fun cancelOrder(cancelOrderRequest: CancelOrderRequest): CancelOrderResponse

    /**
     * Check margin order's status.
     *
     * @param orderStatusRequest order status request options/filters
     * @return an order
     */
    fun getOrderStatus(orderStatusRequest: OrderStatusRequest): Order?

    /**
     * Get margin trades for a specific symbol.
     *
     * @param symbol symbol to get trades from
     * @return a list of trades
     */
    fun getMyTrades(symbol: String?): List<Trade>
    fun getAllPairs(): List<MarginPair>
    fun getMaxBorrowable(asset: String?): MaxBorrowable
    fun newMarginLoan(asset: String?, amount: String?): MarginLoan
    fun newMarginRepay(asset: String?, amount: String?): MarginLoan
    // User stream endpoints
    /**
     * Start a new user data stream.
     *
     * @return a listen key that can be used with data streams
     */
    fun startUserDataStream(): String

    /**
     * PING a user data stream to prevent a time out.
     *
     * @param listenKey listen key that identifies a data stream
     */
    fun keepAliveUserDataStream(listenKey: String?)
}