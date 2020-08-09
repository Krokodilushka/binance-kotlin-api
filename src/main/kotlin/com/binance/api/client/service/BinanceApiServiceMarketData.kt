package com.binance.api.client.service

import com.binance.api.client.BinanceApiConstants
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.marketdata.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BinanceApiServiceMarketData {

    @GET("/api/v3/ping")
    fun ping(): Call<Empty>

    @GET("/api/v3/time")
    fun time(): Call<ServerTime>

    @GET("/api/v3/exchangeInfo")
    fun exchangeInfo(): Call<ExchangeInfo>

    @GET("/api/v3/depth")
    fun depth(
            @Query("symbol") symbol: String,
            @Query("limit") limit: Int?
    ): Call<Depth>

    @GET("/api/v3/trades")
    fun trades(
            @Query("symbol") symbol: String,
            @Query("limit") limit: Int?
    ): Call<List<RecentTrade>>

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/api/v3/historicalTrades")
    fun historicalTrades(
            @Query("symbol") symbol: String,
            @Query("limit") limit: Int?,
            @Query("fromId") fromId: Long?
    ): Call<List<HistoricalTrade>>

    @GET("/api/v3/aggTrades")
    fun aggTrades(
            @Query("symbol") symbol: String,
            @Query("fromId") fromId: Long?,
            @Query("startTime") startTime: Long?,
            @Query("endTime") endTime: Long?,
            @Query("limit") limit: Long?
    ): Call<List<AggregateTrade>>

    @GET("/api/v3/klines")
    fun klines(
            @Query("symbol") symbol: String,
            @Query("interval") interval: String,
            @Query("startTime") startTime: Long?,
            @Query("endTime") endTime: Long?,
            @Query("limit") limit: Long?
    ): Call<List<Candlestick>>

    @GET("/api/v3/avgPrice")
    fun avgPrice(@Query("symbol") symbol: String): Call<AvgPrice>

    @GET("/api/v3/ticker/24hr")
    fun ticker24hr(@Query("symbol") symbol: String): Call<Ticker24hr>

    @GET("/api/v3/ticker/24hr")
    fun tickers24hr(): Call<List<Ticker24hr>>

    @GET("/api/v3/ticker/price")
    fun tickerPrice(@Query("symbol") symbol: String): Call<SymbolPriceTicker>

    @GET("/api/v3/ticker/price")
    fun tickersPrice(): Call<List<SymbolPriceTicker>>

    @GET("/api/v3/ticker/bookTicker")
    fun tickerBookTicker(@Query("symbol") symbol: String?): Call<SymbolOrderBookTicker>

    @GET("/api/v3/ticker/bookTicker")
    fun tickersBookTicker(): Call<List<SymbolOrderBookTicker>>

}