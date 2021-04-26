package com.binance.api.client.impl

import com.binance.api.client.BinanceApiConstants
import com.binance.api.client.BinanceApiSpotRestClient
import com.binance.api.client.domain.NewOrderResponseType
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.binance.api.client.service.BinanceApiServiceGenerator
import com.binance.api.client.service.BinanceApiServiceSpot

/**
 * Implementation of Binance's REST API using Retrofit with synchronous/blocking method calls.
 */
class BinanceApiSpotRestClientImpl(
    apiKey: String?,
    secret: String?,
    baseUrl: String
) : BinanceApiSpotRestClient {

    private val binanceApiService =
        BinanceApiServiceGenerator.createService(BinanceApiServiceSpot::class.java, apiKey, secret, baseUrl)

    override fun newOrderTest(
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

    override fun newOrder(
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

    override fun cancelOrder(
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

    override fun cancelOpenOrders(symbol: String) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.cancelOpenOrders(
            symbol,
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    override fun order(symbol: String, orderId: Long?, origClientOrderId: String?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiService.order(
                symbol,
                orderId,
                origClientOrderId,
                BinanceApiConstants.SPOT_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    override fun openOrders(symbol: String?) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.openOrders(
            symbol,
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    override fun allOrders(symbol: String, orderId: Long?, startTime: Long?, endTime: Long?, limit: Int?) =
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

    override fun newOcoOrder(
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

    override fun cancelOcoOrder(
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

    override fun ocoOrder(orderListId: Long?, origClientOrderId: Long?) =
        BinanceApiServiceGenerator.executeSync(
            binanceApiService.ocoOrder(
                orderListId,
                origClientOrderId,
                BinanceApiConstants.SPOT_RECEIVING_WINDOW,
                System.currentTimeMillis()
            )
        )

    override fun allOcoOrders(fromId: String?, startTime: Long?, endTime: Long?, limit: Int?) =
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

    override fun allOpenOcoOrders() = BinanceApiServiceGenerator.executeSync(
        binanceApiService.allOpenOcoOrders(
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    override fun account() = BinanceApiServiceGenerator.executeSync(
        binanceApiService.account(
            BinanceApiConstants.SPOT_RECEIVING_WINDOW,
            System.currentTimeMillis()
        )
    )

    override fun myTrades(symbol: String, startTime: Long?, endTime: Long?, fromId: Long?, limit: Int?) =
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

    override fun startUserDataStream() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.startUserDataStream())

    override fun keepAliveUserDataStream(listenKey: String) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.keepAliveUserDataStream(listenKey))
    }

    override fun closeUserDataStream(listenKey: String) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.closeUserDataStream(listenKey))
    }

}