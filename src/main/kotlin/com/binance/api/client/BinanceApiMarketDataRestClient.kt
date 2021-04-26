package com.binance.api.client

import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.marketdata.*
import retrofit2.Response

interface BinanceApiMarketDataRestClient {

    /**
     * Test connectivity to the Rest API.
     * @link https://binance-docs.github.io/apidocs/spot/en/#test-connectivity
     */
    fun ping(): Response<Empty>

    /**
     * Test connectivity to the Rest API and get the current server time.
     * @link https://binance-docs.github.io/apidocs/spot/en/#check-server-time
     */
    fun time(): Response<ServerTime>

    /**
     * Current exchange trading rules and symbol information
     * @link https://binance-docs.github.io/apidocs/spot/en/#exchange-information
     */
    fun exchangeInfo(): Response<ExchangeInfo>

    /**
     *
     * @link https://binance-docs.github.io/apidocs/spot/en/#order-book
     */
    fun depth(symbol: String, limit: Int?): Response<Depth>

    /**
     * Get recent trades (up to last 500).
     * @link https://binance-docs.github.io/apidocs/spot/en/#recent-trades-list
     */
    fun trades(symbol: String, limit: Int?): Response<List<RecentTrade>>

    /**
     * Get older market trades.
     * @link https://binance-docs.github.io/apidocs/spot/en/#old-trade-lookup
     */
    fun historicalTrades(symbol: String, limit: Int?, fromId: Long?): Response<List<HistoricalTrade>>

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
    ): Response<List<AggregateTrade>>

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
    ): Response<List<Candlestick>>

    /**
     * Current average price for a symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#current-average-price
     */
    fun avgPrice(symbol: String): Response<AvgPrice>

    /**
     * 24 hour rolling window price change statistics.
     * @link https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics
     */
    fun ticker24hr(symbol: String): Response<Ticker24hr>

    /**
     * 24 hour rolling window price change statistics. Careful when accessing this with no symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics
     */
    fun tickers24hr(): Response<List<Ticker24hr>>

    /**
     * Latest price for a symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker
     */
    fun tickerPrice(symbol: String): Response<SymbolPriceTicker>

    /**
     * Latest price for a symbols.
     * @link https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker
     */
    fun tickersPrice(): Response<List<SymbolPriceTicker>>

    /**
     * Best price/qty on the order book for a symbol.
     * @link https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker
     */
    fun tickerBookTicker(symbol: String): Response<SymbolOrderBookTicker>

    /**
     * Best price/qty on the order book for a symbols.
     * @link https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker
     */
    fun tickersBookTicker(): Response<List<SymbolOrderBookTicker>>
}