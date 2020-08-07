package com.binance.api.client

interface BinanceApiIsolatedMarginRestClient {
    // User stream endpoints
    /**
     * Start a new user data stream.
     *
     * @return a listen key that can be used with data streams
     */
    fun startUserDataStream(symbol: String): String

    /**
     * PING a user data stream to prevent a time out.
     *
     * @param listenKey listen key that identifies a data stream
     */
    fun keepAliveUserDataStream(listenKey: String)
}