package com.binance.api.client

import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.ListenKey
import com.binance.api.client.domain.rest.spot.CancelOrder
import com.binance.api.client.domain.rest.spot.NewOrder
import retrofit2.Response

/**
 * https://binance-docs.github.io/apidocs/spot/en/#spot-account-trade
 */
interface BinanceApiSpotRestClient {

    /**
     * Test new order creation and signature/recvWindow long. Creates and validates a new order but does not send it into the matching engine.
     * @link https://binance-docs.github.io/apidocs/spot/en/#new-order-trade
     */
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
    ): Response<Empty>

    /**
     * Send in a new order.
     * @link https://binance-docs.github.io/apidocs/spot/en/#new-order-trade
     */
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
    ): Response<NewOrder>

    /**
     * Cancel an active order.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cancel-order-trade
     */
    fun cancelOrder(
        symbol: String,
        orderId: Long?,
        origClientOrderId: String?,
        newClientOrderId: String?
    ): Response<CancelOrder>

    /**
     * Cancels all active orders on a symbol.
     * This includes OCO orders.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cancel-all-open-orders-on-a-symbol-trade
     */
    fun cancelOpenOrders(symbol: String): Response<List<CancelOrder>>

    /**
     * Check an order's status.
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-order-user_data
     */
    fun order(
        symbol: String,
        orderId: Long?,
        origClientOrderId: String?
    ): Response<com.binance.api.client.domain.rest.spot.Order>

    /**
     * Get all open orders on a symbol. Careful when accessing this with no symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#current-open-orders-user_data
     */
    fun openOrders(symbol: String?): Response<List<com.binance.api.client.domain.rest.spot.Order>>

    /**
     * Get all account orders; active, canceled, or filled.
     * @link https://binance-docs.github.io/apidocs/spot/en/#all-orders-user_data
     */
    fun allOrders(
        symbol: String,
        orderId: Long?,
        startTime: Long?,
        endTime: Long?,
        limit: Int?
    ): Response<List<com.binance.api.client.domain.rest.spot.Order>>

    /**
     * Send in a new OCO.
     * @link https://binance-docs.github.io/apidocs/spot/en/#new-oco-trade
     */
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
    ): Response<com.binance.api.client.domain.rest.spot.NewOcoOrder>

    /**
     * Cancel an entire Order List.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cancel-oco-trade
     */
    fun cancelOcoOrder(
        symbol: String,
        orderListId: Long?,
        listClientOrderId: String?,
        newClientOrderId: String?
    ): Response<com.binance.api.client.domain.rest.spot.CancelOcoOrder>

    /**
     * Retrieves a specific OCO based on provided optional parameters.
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data
     */
    fun ocoOrder(
        orderListId: Long?,
        origClientOrderId: Long?
    ): Response<com.binance.api.client.domain.rest.spot.OcoOrder>

    /**
     * Retrieves all OCO based on provided optional parameters.
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-all-oco-user_data
     */
    fun allOcoOrders(
        fromId: String?,
        startTime: Long?,
        endTime: Long?,
        limit: Int?
    ): Response<List<com.binance.api.client.domain.rest.spot.OcoOrder>>

    /**
     * Cancel an active order.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cancel-order-trade
     */
    fun allOpenOcoOrders(): Response<List<com.binance.api.client.domain.rest.spot.OcoOrder>>

    /**
     * Get current account information.
     * @link https://binance-docs.github.io/apidocs/spot/en/#account-information-user_data
     */
    fun account(): Response<com.binance.api.client.domain.rest.spot.Account>

    /**
     * Get trades for a specific account and symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#account-trade-list-user_data
     */
    fun myTrades(
        symbol: String,
        startTime: Long?,
        endTime: Long?,
        fromId: Long?,
        limit: Int?
    ): Response<List<com.binance.api.client.domain.rest.spot.Trade>>

    /**
     * Start a new user data stream. The stream will close after 60 minutes unless a keepalive is sent. If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot
     */
    fun startUserDataStream(): Response<ListenKey>

    /**
     * Keepalive a user data stream to prevent a time out. User data streams will close after 60 minutes. It's recommended to send a ping about every 30 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot
     */
    fun keepAliveUserDataStream(listenKey: String)

    /**
     * Close out a user data stream.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot
     */
    fun closeUserDataStream(listenKey: String)
}