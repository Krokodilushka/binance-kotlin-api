package com.binance.api.client

import com.binance.api.client.domain.NewOrderResponseType
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.binance.api.client.service.BinanceApiServiceGenerator
import com.binance.api.client.service.BinanceApiServiceSpot

/**
 * Implementation of Binance's REST API using Retrofit with synchronous/blocking method calls.
 */
class BinanceApiSpotRestClient(
    apiKey: String?,
    secret: String?,
    baseUrl: String
) {

    private val binanceApiService =
        BinanceApiServiceGenerator.createService(BinanceApiServiceSpot::class.java, apiKey, secret, baseUrl)

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
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.newOrderTest(
            symbol,
            side,
            type,
            timeInForce,
            quantity,
            quoteOrderQty,
            price,
            newClientOrderId,
            stopPrice,
            icebergQty,
            NewOrderResponseType.FULL,
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

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
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.newOrder(
            symbol,
            side,
            type,
            timeInForce,
            quantity,
            quoteOrderQty,
            price,
            newClientOrderId,
            stopPrice,
            icebergQty,
            NewOrderResponseType.FULL,
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Cancel an active order.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cancel-order-trade
     */
    fun cancelOrder(
        symbol: String,
        orderId: Long?,
        origClientOrderId: String?,
        newClientOrderId: String?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.cancelOrder(
            symbol,
            orderId,
            origClientOrderId,
            newClientOrderId,
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Cancels all active orders on a symbol.
     * This includes OCO orders.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cancel-all-open-orders-on-a-symbol-trade
     */
    fun cancelOpenOrders(symbol: String) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.cancelOpenOrders(
            symbol,
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Check an order's status.
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-order-user_data
     */
    fun order(symbol: String, orderId: Long?, origClientOrderId: String?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiService.order(
                symbol,
                orderId,
                origClientOrderId,
                BinanceApiConstants.SPOT_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * Get all open orders on a symbol. Careful when accessing this with no symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#current-open-orders-user_data
     */
    fun openOrders(symbol: String?) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.openOrders(
            symbol,
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Get all account orders; active, canceled, or filled.
     * @link https://binance-docs.github.io/apidocs/spot/en/#all-orders-user_data
     */
    fun allOrders(symbol: String, orderId: Long?, startTime: Long?, endTime: Long?, limit: Int?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiService.allOrders(
                symbol,
                orderId,
                startTime,
                endTime,
                limit,
                BinanceApiConstants.SPOT_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

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
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.newOcoOrder(
            symbol,
            listClientOrderId,
            side,
            quantity,
            limitClientOrderId,
            price,
            limitIcebergQty,
            stopClientOrderId,
            stopPrice,
            stopLimitPrice,
            stopIcebergQty,
            stopLimitTimeInForce,
            NewOrderResponseType.FULL,
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Cancel an entire Order List.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cancel-oco-trade
     */
    fun cancelOcoOrder(
        symbol: String,
        orderListId: Long?,
        listClientOrderId: String?,
        newClientOrderId: String?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.cancelOcoOrder(
            symbol,
            orderListId,
            listClientOrderId,
            newClientOrderId,
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Retrieves a specific OCO based on provided optional parameters.
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-oco-user_data
     */
    fun ocoOrder(orderListId: Long?, origClientOrderId: Long?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiService.ocoOrder(
                orderListId,
                origClientOrderId,
                BinanceApiConstants.SPOT_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * Retrieves all OCO based on provided optional parameters.
     * @link https://binance-docs.github.io/apidocs/spot/en/#query-all-oco-user_data
     */
    fun allOcoOrders(fromId: String?, startTime: Long?, endTime: Long?, limit: Int?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiService.allOcoOrders(
                fromId,
                startTime,
                endTime,
                limit,
                BinanceApiConstants.SPOT_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * Cancel an active order.
     * @link https://binance-docs.github.io/apidocs/spot/en/#cancel-order-trade
     */
    fun allOpenOcoOrders() = BinanceApiServiceGenerator.executeSync(
        binanceApiService.allOpenOcoOrders(
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Get current account information.
     * @link https://binance-docs.github.io/apidocs/spot/en/#account-information-user_data
     */
    fun account() = BinanceApiServiceGenerator.executeSync(
        binanceApiService.account(
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    /**
     * Get trades for a specific account and symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#account-trade-list-user_data
     */
    fun myTrades(symbol: String, startTime: Long?, endTime: Long?, fromId: Long?, limit: Int?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiService.myTrades(
                symbol,
                startTime,
                endTime,
                fromId,
                limit,
                BinanceApiConstants.SPOT_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    /**
     * Start a new user data stream. The stream will close after 60 minutes unless a keepalive is sent. If the account has an active listenKey, that listenKey will be returned and its validity will be extended for 60 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot
     */
    fun startUserDataStream() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.startUserDataStream())

    /**
     * Keepalive a user data stream to prevent a time out. User data streams will close after 60 minutes. It's recommended to send a ping about every 30 minutes.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot
     */
    fun keepAliveUserDataStream(listenKey: String) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.keepAliveUserDataStream(listenKey))
    }

    /**
     * Close out a user data stream.
     * @link https://binance-docs.github.io/apidocs/spot/en/#listen-key-spot
     */
    fun closeUserDataStream(listenKey: String) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.closeUserDataStream(listenKey))
    }

}