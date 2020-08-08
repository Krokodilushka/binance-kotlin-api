package com.binance.api.client.service

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.NewOrderResponseType
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderTimeInForce
import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.account.Empty
import com.binance.api.client.domain.event.ListenKey
import retrofit2.Call
import retrofit2.http.*

/**
 * Binance's REST API URL mappings and endpoint security configuration.
 */
interface BinanceApiServiceSpot {

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/test")
    fun newOrderTest(
            @Query("symbol") symbol: String,
            @Query("side") side: OrderSide,
            @Query("type") type: OrderType,
            @Query("timeInForce") timeInForce: OrderTimeInForce?,
            @Query("quantity") quantity: String?,
            @Query("quoteOrderQty") quoteOrderQty: String?,
            @Query("price") price: String?,
            @Query("newClientOrderId") newClientOrderId: String?,
            @Query("stopPrice") stopPrice: String?,
            @Query("icebergQty") icebergQty: String?,
            @Query("newOrderRespType") newOrderRespType: NewOrderResponseType?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<Empty>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order")
    fun newOrder(
            @Query("symbol") symbol: String,
            @Query("side") side: OrderSide,
            @Query("type") type: OrderType,
            @Query("timeInForce") timeInForce: OrderTimeInForce?,
            @Query("quantity") quantity: String?,
            @Query("quoteOrderQty") quoteOrderQty: String?,
            @Query("price") price: String?,
            @Query("newClientOrderId") newClientOrderId: String?,
            @Query("stopPrice") stopPrice: String?,
            @Query("icebergQty") icebergQty: String?,
            @Query("newOrderRespType") newOrderRespType: NewOrderResponseType?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<com.binance.api.client.domain.account.spot.NewOrder>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/api/v3/order")
    fun cancelOrder(
            @Query("symbol") symbol: String,
            @Query("orderId") orderId: Long?,
            @Query("origClientOrderId") origClientOrderId: String?,
            @Query("newClientOrderId") newClientOrderId: String?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<com.binance.api.client.domain.account.spot.CancelOrder>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/api/v3/openOrders")
    fun cancelOpenOrders(
            @Query("symbol") symbol: String,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<List<com.binance.api.client.domain.account.spot.CancelOrder>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/order")
    fun order(
            @Query("symbol") symbol: String,
            @Query("orderId") orderId: Long?,
            @Query("origClientOrderId") origClientOrderId: String?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<com.binance.api.client.domain.account.spot.Order>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/openOrders")
    fun openOrders(
            @Query("symbol") symbol: String?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<List<com.binance.api.client.domain.account.spot.Order>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/allOrders")
    fun allOrders(
            @Query("symbol") symbol: String,
            @Query("orderId") orderId: Long?,
            @Query("startTime") startTime: Long?,
            @Query("endTime") endTime: Long?,
            @Query("limit") limit: Int?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<List<com.binance.api.client.domain.account.spot.Order>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/oco")
    fun newOcoOrder(
            @Query("symbol") symbol: String,
            @Query("listClientOrderId") orderId: String?,
            @Query("side") side: OrderSide,
            @Query("quantity") quantity: String,
            @Query("limitClientOrderId") limitClientOrderId: String?,
            @Query("price") price: String,
            @Query("limitIcebergQty") limitIcebergQty: String?,
            @Query("stopClientOrderId") stopClientOrderId: String?,
            @Query("stopPrice") stopPrice: String,
            @Query("stopLimitPrice") stopLimitPrice: String?,
            @Query("stopIcebergQty") stopIcebergQty: String?,
            @Query("stopLimitTimeInForce") stopLimitTimeInForce: OrderTimeInForce?,
            @Query("newOrderRespType") newOrderRespType: NewOrderResponseType?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<com.binance.api.client.domain.account.spot.NewOcoOrder>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/api/v3/orderList")
    fun cancelOcoOrder(
            @Query("symbol") symbol: String,
            @Query("orderListId") orderListId: Long?,
            @Query("listClientOrderId") listClientOrderId: String?,
            @Query("newClientOrderId") newClientOrderId: String?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<com.binance.api.client.domain.account.spot.CancelOcoOrder>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/orderList")
    fun ocoOrder(
            @Query("orderListId") orderListId: Long?,
            @Query("origClientOrderId") orderId: Long?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<com.binance.api.client.domain.account.spot.OcoOrder>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/allOrderList")
    fun allOcoOrders(
            @Query("fromId") fromId: String?,
            @Query("startTime") startTime: Long?,
            @Query("endTime") endTime: Long?,
            @Query("limit") limit: Int?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<List<com.binance.api.client.domain.account.spot.OcoOrder>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/openOrderList")
    fun allOpenOcoOrders(
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<List<com.binance.api.client.domain.account.spot.OcoOrder>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/account")
    fun account(
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<com.binance.api.client.domain.account.spot.Account>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/myTrades")
    fun myTrades(
            @Query("symbol") symbol: String,
            @Query("startTime") startTime: Long?,
            @Query("endTime") endTime: Long?,
            @Query("fromId") fromId: Long?,
            @Query("limit") limit: Int?,
            @Query("recvWindow") recvWindow: Long?,
            @Query("timestamp") timestamp: Long
    ): Call<List<com.binance.api.client.domain.account.spot.Trade>>


    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/api/v3/userDataStream")
    fun startUserDataStream(): Call<ListenKey>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/api/v3/userDataStream")
    fun keepAliveUserDataStream(@Query("listenKey") listenKey: String): Call<Empty>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @DELETE("/api/v3/userDataStream")
    fun closeUserDataStream(@Query("listenKey") listenKey: String): Call<Empty>
}