package com.binance.api.client

import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.service.BinanceApiServiceGenerator
import com.binance.api.client.service.BinanceApiServiceMarketData

class BinanceApiMarketDataRestClient(
    apiKey: String?,
    secret: String?,
    baseUrl: String
) {

    private val binanceApiService =
        BinanceApiServiceGenerator.createService(BinanceApiServiceMarketData::class.java, apiKey, secret, baseUrl)

    /**
     * Test connectivity to the Rest API.
     * @link https://binance-docs.github.io/apidocs/spot/en/#test-connectivity
     */
    fun ping() = BinanceApiServiceGenerator.executeSync(binanceApiService.ping())

    /**
     * Test connectivity to the Rest API and get the current server time.
     * @link https://binance-docs.github.io/apidocs/spot/en/#check-server-time
     */
    fun time() = BinanceApiServiceGenerator.executeSync(binanceApiService.time())

    /**
     * Current exchange trading rules and symbol information
     * @link https://binance-docs.github.io/apidocs/spot/en/#exchange-information
     */
    fun exchangeInfo() = BinanceApiServiceGenerator.executeSync(binanceApiService.exchangeInfo())

    /**
     * @link https://binance-docs.github.io/apidocs/spot/en/#order-book
     */
    fun depth(symbol: String, limit: Int?) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.depth(symbol, limit))

    /**
     * Get recent trades (up to last 500).
     * @link https://binance-docs.github.io/apidocs/spot/en/#recent-trades-list
     */
    fun trades(symbol: String, limit: Int?) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.trades(symbol, limit))

    /**
     * Get older market trades.
     * @link https://binance-docs.github.io/apidocs/spot/en/#old-trade-lookup
     */
    fun historicalTrades(symbol: String, limit: Int?, fromId: Long?) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.historicalTrades(symbol, limit, fromId))

    /**
     * Get compressed, aggregate trades. Trades that fill at the time, from the same order, with the same price will have the quantity aggregated.
     * @link https://binance-docs.github.io/apidocs/spot/en/#compressed-aggregate-trades-list
     */
    fun aggTrades(
        symbol: String,
        fromId: Long?,
        startTime: Long?,
        endTime: Long?,
        limit: Long?
    ) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.aggTrades(symbol, fromId, startTime, endTime, limit))

    /**
     * Kline/candlestick bars for a symbol.
     * Klines are uniquely identified by their open time.
     * @link https://binance-docs.github.io/apidocs/spot/en/#kline-candlestick-data
     */
    fun candles(
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

    /**
     * Current average price for a symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#current-average-price
     */
    fun avgPrice(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.avgPrice(symbol))

    /**
     * 24 hour rolling window price change statistics.
     * @link https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics
     */
    fun ticker24hr(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.ticker24hr(symbol))

    /**
     * 24 hour rolling window price change statistics. Careful when accessing this with no symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics
     */
    fun tickers24hr() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickers24hr())

    /**
     * Latest price for a symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker
     */
    fun tickerPrice(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickerPrice(symbol))

    /**
     * Latest price for a symbols.
     * @link https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker
     */
    fun tickersPrice() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickersPrice())

    /**
     * Best price/qty on the order book for a symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker
     */
    fun tickerBookTicker(symbol: String) =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickerBookTicker(symbol))

    /**
     * Best price/qty on the order book for a symbols.
     * @link https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker
     */
    fun tickersBookTicker() =
        BinanceApiServiceGenerator.executeSync(binanceApiService.tickersBookTicker())

}