package com.binance.api.client

import com.binance.api.client.domain.CandlestickInterval
import com.binance.api.client.domain.event.*
import java.io.Closeable

/**
 * Binance API data streaming façade, supporting streaming of events through web sockets.
 */
interface BinanceWebSocketClient {
    /**
     * Open a new web socket to receive [depthEvents][DepthEvent] on a callback.
     *
     * @param symbols   market (one or coma-separated) symbol(s) to subscribe to
     * @param callback  the callback to call on new events
     * @return a [Closeable] that allows the underlying web socket to be closed.
     */
    fun onDepthEvent(symbols: String, callback: WebSocketCallback<DepthEvent>): Closeable

    /**
     * Open a new web socket to receive [candlestickEvents][CandlestickEvent] on a callback.
     *
     * @param symbols   market (one or coma-separated) symbol(s) to subscribe to
     * @param interval  the interval of the candles tick events required
     * @param callback  the callback to call on new events
     * @return a [Closeable] that allows the underlying web socket to be closed.
     */
    fun onCandlestickEvent(symbols: String, interval: CandlestickInterval, callback: WebSocketCallback<CandlestickEvent>): Closeable

    /**
     * Open a new web socket to receive [aggTradeEvents][AggTradeEvent] on a callback.
     *
     * @param symbols   market (one or coma-separated) symbol(s) to subscribe to
     * @param callback  the callback to call on new events
     * @return a [Closeable] that allows the underlying web socket to be closed.
     */
    fun onAggTradeEvent(symbols: String, callback: WebSocketCallback<AggTradeEvent>): Closeable

    /**
     * Open a new web socket to receive [userDataUpdateEvents][UserDataUpdateEvent] on a callback.
     *
     * @param listenKey the listen key to subscribe to.
     * @param callback  the callback to call on new events
     * @return a [Closeable] that allows the underlying web socket to be closed.
     */
    fun onUserDataUpdateEvent(listenKey: String, callback: WebSocketCallback<UserDataUpdateEvent>): Closeable

    /**
     * Open a new web socket to receive [allMarketTickersEvents][AllMarketTickersEvent] on a callback.
     *
     * @param callback the callback to call on new events
     * @return a [Closeable] that allows the underlying web socket to be closed.
     */
    fun onAllMarketTickersEvent(callback: WebSocketCallback<List<AllMarketTickersEvent>>): Closeable
}