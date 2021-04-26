package com.binance.api.client.impl

import com.binance.api.client.BinanceApiMarketDataRestClient
import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.service.BinanceApiServiceGenerator
import com.binance.api.client.service.BinanceApiServiceMarketData

class BinanceApiMarketDataRestClientImpl(
    apiKey: String?,
    secret: String?,
    baseUrl: String
) : BinanceApiMarketDataRestClient {

    private val binanceApiService =
        BinanceApiServiceGenerator.createService(BinanceApiServiceMarketData::class.java, apiKey, secret, baseUrl)

    override fun ping() = BinanceApiServiceGenerator.executeSync(binanceApiService.ping())

    override fun time() = BinanceApiServiceGenerator.executeSync(binanceApiService.time())

    override fun exchangeInfo() = BinanceApiServiceGenerator.executeSync(binanceApiService.exchangeInfo())

    override fun depth(symbol: String, limit: Int?) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.depth(symbol, limit))

    override fun trades(symbol: String, limit: Int?) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.trades(symbol, limit))

    override fun historicalTrades(symbol: String, limit: Int?, fromId: Long?) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.historicalTrades(symbol, limit, fromId))

    override fun aggTrades(
        symbol: String,
        fromId: Long?,
        startTime: Long?,
        endTime: Long?,
        limit: Long?
    ) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.aggTrades(symbol, fromId, startTime, endTime, limit))

    override fun candles(
        symbol: String,
        interval: CandlestickInterval,
        startTime: Long?,
        endTime: Long?,
        limit: Long?
    ) = BinanceApiServiceGenerator.executeSync(
        binanceApiService.klines(
            symbol,
            interval.intervalId,
            startTime,
            endTime,
            limit
        )
    )

    override fun avgPrice(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.avgPrice(symbol))

    override fun ticker24hr(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.ticker24hr(symbol))

    override fun tickers24hr() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickers24hr())

    override fun tickerPrice(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickerPrice(symbol))

    override fun tickersPrice() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickersPrice())

    override fun tickerBookTicker(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickerBookTicker(symbol))

    override fun tickersBookTicker() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickersBookTicker())

}