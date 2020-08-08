package com.binance.api.client

import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.marketdata.*

interface BinanceApiMarketDataRestClient {

    fun ping(): Empty

    fun time(): ServerTime

    fun exchangeInfo(): ExchangeInfo

    fun depth(
            symbol: String,
            limit: Int?
    ): Depth

    fun trades(
            symbol: String,
            limit: Int?
    ): List<RecentTrade>

    fun historicalTrades(
            symbol: String,
            limit: Int?,
            fromId: Long?
    ): List<HistoricalTrade>

    fun aggTrades(
            symbol: String,
            fromId: Long?,
            startTime: Long?,
            endTime: Long?,
            limit: Long?
    ): List<AggregateTrade>

    fun klines(
            symbol: String,
            interval: CandlestickInterval,
            startTime: Long?,
            endTime: Long?,
            limit: Long?
    ): List<Candlestick>

    fun avgPrice(symbol: String): AvgPrice

    fun ticker24hr(symbol: String): Ticker24hr

    fun tickers24hr(): List<Ticker24hr>

    fun tickerPrice(symbol: String): SymbolPriceTicker

    fun tickersPrice(): List<SymbolPriceTicker>

    fun tickerBookTicker(symbol: String): SymbolOrderBookTicker

    fun tickersBookTicker(): List<SymbolOrderBookTicker>
}