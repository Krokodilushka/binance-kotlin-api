package com.binance.api.client

import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.rest.Empty
import com.binance.api.client.domain.rest.marketdata.*

interface BinanceApiMarketDataRestClient {

    /**
     * Test connectivity to the Rest API.
     * @see https://binance-docs.github.io/apidocs/spot/en/#test-connectivity
     */
    fun ping(): Empty

    /**
     * Test connectivity to the Rest API and get the current server time.
     * @see https://binance-docs.github.io/apidocs/spot/en/#check-server-time
     */
    fun time(): ServerTime

    /**
     * Current exchange trading rules and symbol information
     * @see https://binance-docs.github.io/apidocs/spot/en/#exchange-information
     */
    fun exchangeInfo(): ExchangeInfo

    /**
     *
     * @see https://binance-docs.github.io/apidocs/spot/en/#order-book
     */
    fun depth(symbol: String, limit: Int?): Depth

    /**
     * Get recent trades (up to last 500).
     * @see https://binance-docs.github.io/apidocs/spot/en/#recent-trades-list
     */
    fun trades(symbol: String, limit: Int?): List<RecentTrade>

    /**
     * Get older market trades.
     * @see https://binance-docs.github.io/apidocs/spot/en/#old-trade-lookup
     */
    fun historicalTrades(symbol: String, limit: Int?, fromId: Long?): List<HistoricalTrade>

    /**
     * Get compressed, aggregate trades. Trades that fill at the time, from the same order, with the same price will have the quantity aggregated.
     * @see https://binance-docs.github.io/apidocs/spot/en/#compressed-aggregate-trades-list
     */
    fun aggTrades(symbol: String, fromId: Long?, startTime: Long?, endTime: Long?, limit: Long?): List<AggregateTrade>

    /**
     * Kline/candlestick bars for a symbol.
     * Klines are uniquely identified by their open time.
     * @see https://binance-docs.github.io/apidocs/spot/en/#kline-candlestick-data
     */
    fun candles(symbol: String, interval: CandlestickInterval, startTime: Long?, endTime: Long?, limit: Long?): List<Candlestick>

    /**
     * Current average price for a symbol.
     * @see https://binance-docs.github.io/apidocs/spot/en/#current-average-price
     */
    fun avgPrice(symbol: String): AvgPrice

    /**
     * 24 hour rolling window price change statistics.
     * @see https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics
     */
    fun ticker24hr(symbol: String): Ticker24hr

    /**
     * 24 hour rolling window price change statistics. Careful when accessing this with no symbol.
     * @see https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics
     */
    fun tickers24hr(): List<Ticker24hr>

    /**
     * Latest price for a symbol.
     * @see https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker
     */
    fun tickerPrice(symbol: String): SymbolPriceTicker

    /**
     * Latest price for a symbols.
     * @see https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker
     */
    fun tickersPrice(): List<SymbolPriceTicker>

    /**
     * Best price/qty on the order book for a symbol.
     * @see https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker
     */
    fun tickerBookTicker(symbol: String): SymbolOrderBookTicker

    /**
     * Best price/qty on the order book for a symbols.
     * @see https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker
     */
    fun tickersBookTicker(): List<SymbolOrderBookTicker>
}