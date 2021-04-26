package com.binance.api.client.service

import com.binance.api.client.BinanceApiConstants
import com.binance.api.client.domain.*
import com.binance.api.client.domain.rest.Amount
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.ListenKey
import com.binance.api.client.domain.rest.Transaction
import com.binance.api.client.domain.rest.margin.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Included changes at 2021-03-05
 */
interface BinanceApiServiceMargin {
    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/transfer")
    fun newCrossTransfer(
        @Query("asset") asset: String,
        @Query("amount") amount: String,
        @Query("type") type: Short,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<Transaction>


    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/loan")
    fun newLoan(
        @Query("asset") asset: String,
        @Query("isIsolated") isIsolated: Boolean?,
        @Query("symbol") symbol: String?,
        @Query("amount") amount: String,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<Transaction>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/repay")
    fun newRepay(
        @Query("asset") asset: String,
        @Query("isIsolated") isIsolated: Boolean?,
        @Query("txId") symbol: String?,
        @Query("amount") amount: String,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<Transaction>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/sapi/v1/margin/asset")
    fun asset(@Query("asset") symbol: String): Call<CrossMarginAsset>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/sapi/v1/margin/pair")
    fun pair(@Query("symbol") symbol: String): Call<MarginPair>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/sapi/v1/margin/allAssets")
    fun allAssets(): Call<List<CrossMarginAsset>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/sapi/v1/margin/allPairs")
    fun allPairs(): Call<List<MarginPair>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/sapi/v1/margin/priceIndex")
    fun priceIndex(@Query("symbol") symbol: String): Call<PriceIndex>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/order")
    fun newOrder(
        @Query("symbol") symbol: String,
        @Query("isIsolated") isIsolated: Boolean?,
        @Query("side") side: OrderSide,
        @Query("type") type: OrderType,
        @Query("quantity") quantity: String,
        @Query("quoteOrderQty") quoteOrderQty: String?,
        @Query("price") price: String?,
        @Query("stopPrice") stopPrice: String?,
        @Query("icebergQty") icebergQty: String?,
        @Query("newClientOrderId") newClientOrderId: String?,
        @Query("newOrderRespType") newOrderRespType: NewOrderResponseType?,
        @Query("sideEffectType") sideEffectType: OrderSideEffectType?,
        @Query("timeInForce") timeInForce: OrderTimeInForce?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long?
    ): Call<NewOrder>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/sapi/v1/margin/order")
    fun cancelOrder(
        @Query("symbol") symbol: String,
        @Query("isIsolated") isIsolated: Boolean?,
        @Query("orderId") orderId: Long?,
        @Query("origClientOrderId") origClientOrderId: String?,
        @Query("newClientOrderId") newClientOrderId: String?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<CancelOrder>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/sapi/v1/margin/openOrders")
    fun cancelOpenOrders(
        @Query("symbol") symbol: String,
        @Query("isIsolated") isIsolated: Boolean?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<List<CancelAllOpenOrders>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/transfer")
    fun crossTransfer(
        @Query("asset") asset: String?,
        @Query("type") type: CrossMarginTransferType?,
        @Query("startTime") startTime: String?,
        @Query("endTime") endTime: String?,
        @Query("current") current: String?,
        @Query("size") size: String?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<TransferHistory>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/loan")
    fun loan(
        @Query("asset") asset: String,
        @Query("isolatedSymbol") isolatedSymbol: String?,
        @Query("txId") txId: Long?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("current") current: Long?,
        @Query("size") size: Long?,
        @Query("archived") archived: Boolean?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<LoanRecord>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/repay")
    fun repay(
        @Query("asset") asset: String,
        @Query("isolatedSymbol") isolatedSymbol: Boolean?,
        @Query("txId") txId: Long?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("current") current: Long?,
        @Query("size") size: Long?,
        @Query("archived") archived: Boolean?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long?
    ): Call<RepayRecord>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/interestHistory")
    fun interestHistory(
        @Query("asset") asset: String?,
        @Query("isolatedSymbol") isolatedSymbol: String?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("current") current: Long?,
        @Query("size") size: Long?,
        @Query("archived") archived: Boolean?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<InterestHistory>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/forceLiquidationRec")
    fun forceLiquidationRec(
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("isolatedSymbol") isolatedSymbol: Boolean?,
        @Query("current") current: Long?,
        @Query("size") size: Long?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long?
    ): Call<ForceLiquidationRecord>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/account")
    fun account(
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<Account>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/order")
    fun order(
        @Query("symbol") symbol: String,
        @Query("isIsolated") isIsolated: Boolean?,
        @Query("orderId") orderId: Long?,
        @Query("origClientOrderId") origClientOrderId: String?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long?
    ): Call<Order>

    @Headers(
        BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
        BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER
    )
    @GET("/sapi/v1/margin/openOrders")
    fun openOrders(
        @Query("symbol") symbol: String?,
        @Query("isIsolated") isIsolated: Boolean?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<List<Order>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/allOrders")
    fun allOrders(
        @Query("symbol") symbol: String,
        @Query("isIsolated") isIsolated: Boolean?,
        @Query("orderId") orderId: Long?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("limit") limit: Int?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<List<Order>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/myTrades")
    fun myTrades(
        @Query("symbol") symbol: String,
        @Query("isIsolated") isIsolated: Boolean?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("fromId") fromId: Long?,
        @Query("limit") limit: Int?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<List<Trade>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/maxBorrowable")
    fun maxBorrowable(
        @Query("asset") asset: String,
        @Query("isolatedSymbol") isolatedSymbol: String?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long?
    ): Call<MaxBorrowable>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/maxTransferable")
    fun maxTransferable(
        @Query("asset") asset: String,
        @Query("isolatedSymbol") isolatedSymbol: String?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long?
    ): Call<Amount>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/isolated/create")
    fun isolatedCreate(
        @Query("base") base: String,
        @Query("quote") quote: String,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<CreateIsolatedAccount>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/isolated/transfer")
    fun newIsolatedTransfer(
        @Query("asset") asset: String,
        @Query("symbol") symbol: String,
        @Query("transFrom") transFrom: TransactionTarget,
        @Query("transTo") transTo: TransactionTarget,
        @Query("amount") amount: String,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<Transaction>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/isolated/transfer")
    fun isolatedTransfer(
        @Query("asset") asset: String?,
        @Query("symbol") symbol: String,
        @Query("transFrom") transFrom: TransactionTarget?,
        @Query("transTo") transTo: TransactionTarget?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("current") current: Long?,
        @Query("size") size: Long?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<IsolatedTransferHistory>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/isolated/account")
    fun isolatedAccount(
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<IsolatedAccountInfo>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/isolated/account")
    fun isolatedAccount(
        @Query("symbols") string: String,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<IsolatedAccountInfo.IsolatedAccountInfoSymbols>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/isolated/pair")
    fun isolatedPair(
        @Query("symbol") symbol: String?,
        @Query("recvWindow") recvWindow: Long?,
        @Query("timestamp") timestamp: Long
    ): Call<IsolatedPair>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/isolated/allPairs")
    fun isolatedAllPairs(
        @Query("recvWindow")
        recvWindow: Long?,
        @Query("timestamp")
        timestamp: Long
    ): Call<List<IsolatedPair>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/bnbBurn")
    fun bnbBurn(
        @Query("spotBNBBurn")
        spotBNBBurn: Boolean?,
        @Query("interestBNBBurn")
        interestBNBBurn: Boolean?,
        @Query("recvWindow")
        recvWindow: Long?,
        @Query("timestamp")
        timestamp: Long
    ): Call<BnbBurn>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/bnbBurn")
    fun bnbBurn(
        @Query("recvWindow")
        recvWindow: Long?,
        @Query("timestamp")
        timestamp: Long
    ): Call<BnbBurn>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/interestRateHistory")
    fun interestRateHistory(
        @Query("asset")
        asset: String,
        @Query("vipLevel")
        vipLevel: String?,
        @Query("startTime")
        startTime: String?,
        @Query("endTime")
        endTime: String?,
        @Query("limit")
        limit: Int?,
        @Query("recvWindow")
        recvWindow: Long?,
        @Query("timestamp")
        timestamp: Long
    ): Call<List<MarginInterestRateHistory>>


    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/sapi/v1/userDataStream")
    fun startMarginUserDataStream(): Call<ListenKey>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/sapi/v1/userDataStream")
    fun keepAliveMarginUserDataStream(@Query("listenKey") listenKey: String): Call<Empty>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @DELETE("/sapi/v1/userDataStream")
    fun closeMarginUserDataStream(@Query("listenKey") listenKey: String): Call<Empty>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/sapi/v1/userDataStream/isolated")
    fun startIsolatedMarginUserDataStream(@Query("symbol") symbol: String): Call<ListenKey>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/sapi/v1/userDataStream/isolated")
    fun keepAliveIsolatedMarginUserDataStream(@Query("listenKey") listenKey: String): Call<Empty>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @DELETE("/sapi/v1/userDataStream/isolated")
    fun closeIsolatedMarginUserDataStream(@Query("listenKey") listenKey: String): Call<Empty>
}