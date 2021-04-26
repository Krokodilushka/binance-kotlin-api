package com.binance.api.client.impl

import com.binance.api.client.BinanceApiMarketDataRestClient
import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.marketdata.*
import com.binance.api.client.service.BinanceApiServiceGenerator
import com.binance.api.client.service.BinanceApiServiceMarketData

class BinanceApiMarketDataRestClientImpl(
    apiKey: String?,
    secret: String?,
    baseUrl: String
) : BinanceApiMarketDataRestClient {

    private val binanceApiService =
        BinanceApiServiceGenerator.createService(BinanceApiServiceMarketData::class.java, apiKey, secret, baseUrl)

    override fun ping(): Empty = BinanceApiServiceGenerator.executeSync(binanceApiService.ping())

    override fun time(): ServerTime = BinanceApiServiceGenerator.executeSync(binanceApiService.time())

    override fun exchangeInfo(): ExchangeInfo = BinanceApiServiceGenerator.executeSync(binanceApiService.exchangeInfo())

    override fun depth(symbol: String, limit: Int?): Depth =
        BinanceApiServiceGenerator.executeSync(binanceApiService.depth(symbol, limit))

    override fun trades(symbol: String, limit: Int?): List<RecentTrade> =
        BinanceApiServiceGenerator.executeSync(binanceApiService.trades(symbol, limit))

    override fun historicalTrades(symbol: String, limit: Int?, fromId: Long?): List<HistoricalTrade> =
        BinanceApiServiceGenerator.executeSync(binanceApiService.historicalTrades(symbol, limit, fromId))

    override fun aggTrades(
        symbol: String,
        fromId: Long?,
        startTime: Long?,
        endTime: Long?,
        limit: Long?
    ): List<AggregateTrade> =
        BinanceApiServiceGenerator.executeSync(binanceApiService.aggTrades(symbol, fromId, startTime, endTime, limit))

    override fun candles(
        symbol: String,
        interval: CandlestickInterval,
        startTime: Long?,
        endTime: Long?,
        limit: Long?
    ): List<Candlestick> = BinanceApiServiceGenerator.executeSync(
        binanceApiService.klines(
            symbol,
            interval.intervalId,
            startTime,
            endTime,
            limit
        )
    )

    override fun avgPrice(symbol: String): AvgPrice =
        BinanceApiServiceGenerator.executeSync(binanceApiService.avgPrice(symbol))

    override fun ticker24hr(symbol: String): Ticker24hr =
        BinanceApiServiceGenerator.executeSync(binanceApiService.ticker24hr(symbol))

    override fun tickers24hr(): List<Ticker24hr> =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickers24hr())

    override fun tickerPrice(symbol: String): SymbolPriceTicker =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickerPrice(symbol))

    override fun tickersPrice(): List<SymbolPriceTicker> =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickersPrice())

    override fun tickerBookTicker(symbol: String): SymbolOrderBookTicker =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickerBookTicker(symbol))

    override fun tickersBookTicker(): List<SymbolOrderBookTicker> =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickersBookTicker())

}