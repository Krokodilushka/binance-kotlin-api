package com.binance.api.client.impl

import com.binance.api.client.constant.BinanceApiConstants
import com.binance.api.client.domain.OrderSide
import com.binance.api.client.domain.OrderType
import com.binance.api.client.domain.TimeInForce
import com.binance.api.client.domain.account.*
import com.binance.api.client.domain.account.request.CancelOrderResponse
import com.binance.api.client.domain.event.ListenKey
import com.binance.api.client.domain.general.Asset
import com.binance.api.client.domain.general.ExchangeInfo
import com.binance.api.client.domain.general.MarginPair
import com.binance.api.client.domain.general.ServerTime
import com.binance.api.client.domain.market.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Binance's REST API URL mappings and endpoint security configuration.
 */
interface BinanceApiService {
    // General endpoints
    @GET("/api/v1/ping")
    fun ping(): Call<Void>

    @GET("/api/v1/time")
    fun getServerTime(): Call<ServerTime>

    @GET("/api/v1/exchangeInfo")
    fun getExchangeInfo(): Call<ExchangeInfo>

    @GET
    fun getAllAssets(@Url url: String?): Call<List<Asset>>

    // Market data endpoints
    @GET("/api/v1/depth")
    fun getOrderBook(@Query("symbol") symbol: String?, @Query("limit") limit: Int?): Call<OrderBook>

    @GET("/api/v1/trades")
    fun getTrades(@Query("symbol") symbol: String?, @Query("limit") limit: Int?): Call<List<TradeHistoryItem>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/api/v1/historicalTrades")
    fun getHistoricalTrades(@Query("symbol") symbol: String?, @Query("limit") limit: Int?, @Query("fromId") fromId: Long?): Call<List<TradeHistoryItem>>

    @GET("/api/v1/aggTrades")
    fun getAggTrades(@Query("symbol") symbol: String?, @Query("fromId") fromId: String?, @Query("limit") limit: Int?,
                     @Query("startTime") startTime: Long?, @Query("endTime") endTime: Long?): Call<List<AggTrade>>

    @GET("/api/v1/klines")
    fun getCandlestickBars(@Query("symbol") symbol: String?, @Query("interval") interval: String?, @Query("limit") limit: Int?,
                           @Query("startTime") startTime: Long?, @Query("endTime") endTime: Long?): Call<List<Candlestick>>

    @GET("/api/v1/ticker/24hr")
    fun get24HrPriceStatistics(@Query("symbol") symbol: String?): Call<List<TickerStatistics>>

    @GET("/api/v1/ticker/24hr")
    fun getAll24HrPriceStatistics(): Call<List<TickerStatistics>>

    @GET("/api/v1/ticker/allPrices")
    fun getLatestPrices(): Call<List<TickerPrice>>

    @GET("/api/v3/ticker/price")
    fun getLatestPrice(@Query("symbol") symbol: String?): Call<TickerPrice>

    @GET("/api/v1/ticker/allBookTickers")
    fun getBookTickers(): Call<List<BookTicker>>

    // Account endpoints
    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order")
    fun newOrder(@Query("symbol") symbol: String?, @Query("side") side: OrderSide?, @Query("type") type: OrderType?,
                 @Query("timeInForce") timeInForce: TimeInForce?, @Query("quantity") quantity: String?, @Query("price") price: String?,
                 @Query("newClientOrderId") newClientOrderId: String?, @Query("stopPrice") stopPrice: String?,
                 @Query("icebergQty") icebergQty: String?, @Query("newOrderRespType") newOrderRespType: NewOrderResponseType?,
                 @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<NewOrderResponse>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/test")
    fun newOrderTest(@Query("symbol") symbol: String?, @Query("side") side: OrderSide?, @Query("type") type: OrderType?,
                     @Query("timeInForce") timeInForce: TimeInForce?, @Query("quantity") quantity: String?, @Query("price") price: String?,
                     @Query("newClientOrderId") newClientOrderId: String?, @Query("stopPrice") stopPrice: String?,
                     @Query("icebergQty") icebergQty: String?, @Query("newOrderRespType") newOrderRespType: NewOrderResponseType?,
                     @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<Void>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/order")
    fun getOrderStatus(@Query("symbol") symbol: String?, @Query("orderId") orderId: Long?,
                       @Query("origClientOrderId") origClientOrderId: String?, @Query("recvWindow") recvWindow: Long?,
                       @Query("timestamp") timestamp: Long?): Call<Order>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/api/v3/order")
    fun cancelOrder(@Query("symbol") symbol: String?, @Query("orderId") orderId: Long?,
                    @Query("origClientOrderId") origClientOrderId: String?, @Query("newClientOrderId") newClientOrderId: String?,
                    @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<CancelOrderResponse>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/openOrders")
    fun getOpenOrders(@Query("symbol") symbol: String?, @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<List<Order>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/allOrders")
    fun getAllOrders(@Query("symbol") symbol: String?, @Query("orderId") orderId: Long?,
                     @Query("limit") limit: Int?, @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<List<Order>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/account")
    fun getAccount(@Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<Account>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/myTrades")
    fun getMyTrades(@Query("symbol") symbol: String?, @Query("limit") limit: Int?, @Query("fromId") fromId: Long?,
                    @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<List<Trade>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/wapi/v3/withdraw.html")
    fun withdraw(@Query("asset") asset: String?, @Query("address") address: String?, @Query("amount") amount: String?, @Query("name") name: String?, @Query("addressTag") addressTag: String?,
                 @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<WithdrawResult>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/wapi/v3/depositHistory.html")
    fun getDepositHistory(@Query("asset") asset: String?, @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<DepositHistory>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/wapi/v3/withdrawHistory.html")
    fun getWithdrawHistory(@Query("asset") asset: String?, @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<WithdrawHistory>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/wapi/v3/depositAddress.html")
    fun getDepositAddress(@Query("asset") asset: String?, @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<DepositAddress>

    // User stream endpoints
    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/api/v1/userDataStream")
    fun startUserDataStream(): Call<ListenKey>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/api/v1/userDataStream")
    fun keepAliveUserDataStream(@Query("listenKey") listenKey: String?): Call<Void>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @DELETE("/api/v1/userDataStream")
    fun closeAliveUserDataStream(@Query("listenKey") listenKey: String?): Call<Void>

    // Margin Account endpoints
    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/account")
    fun getMarginAccount(@Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<MarginAccount>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/openOrders")
    fun getOpenMarginOrders(@Query("symbol") symbol: String?, @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<List<Order>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/order")
    fun newMarginOrder(@Query("symbol") symbol: String?, @Query("side") side: OrderSide?, @Query("type") type: OrderType?,
                       @Query("timeInForce") timeInForce: TimeInForce?, @Query("quantity") quantity: String?, @Query("price") price: String?,
                       @Query("newClientOrderId") newClientOrderId: String?, @Query("stopPrice") stopPrice: String?,
                       @Query("icebergQty") icebergQty: String?, @Query("newOrderRespType") newOrderRespType: NewOrderResponseType?,
                       @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<NewOrderResponse>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/sapi/v1/margin/order")
    fun cancelMarginOrder(@Query("symbol") symbol: String?, @Query("orderId") orderId: Long?,
                          @Query("origClientOrderId") origClientOrderId: String?, @Query("newClientOrderId") newClientOrderId: String?,
                          @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<CancelOrderResponse>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/order")
    fun getMarginOrderStatus(@Query("symbol") symbol: String?, @Query("orderId") orderId: Long?,
                             @Query("origClientOrderId") origClientOrderId: String?, @Query("recvWindow") recvWindow: Long?,
                             @Query("timestamp") timestamp: Long?): Call<Order>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/myTrades")
    fun getMyMarginTrades(@Query("symbol") symbol: String?, @Query("limit") limit: Int?, @Query("fromId") fromId: Long?,
                          @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<List<Trade>>

    @GET("/sapi/v1/margin/allPairs")
    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    fun allPairs(): Call<List<MarginPair>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/maxBorrowable")
    fun getMaxBorrowable(@Query("asset") asset: String?, @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<MaxBorrowable>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/loan")
    fun newMarginLoan(@Query("asset") asset: String?, @Query("amount") amount: String?, @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<MarginLoan>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/repay")
    fun newMarginRepay(@Query("asset") asset: String?, @Query("amount") amount: String?, @Query("recvWindow") recvWindow: Long?, @Query("timestamp") timestamp: Long?): Call<MarginLoan>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/sapi/v1/userDataStream")
    fun startMarginUserDataStream(): Call<ListenKey>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/sapi/v1/userDataStream")
    fun keepAliveMarginUserDataStream(@Query("listenKey") listenKey: String?): Call<Void>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/sapi/v1/userDataStream/isolated")
    fun startIsolatedMarginUserDataStream(@Query("symbol") symbol: String?): Call<ListenKey>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/sapi/v1/userDataStream/isolated")
    fun keepAliveIsolatedMarginUserDataStream(@Query("listenKey") listenKey: String?): Call<Void>
}