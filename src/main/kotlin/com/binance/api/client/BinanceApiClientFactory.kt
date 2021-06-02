package com.binance.api.client

import com.binance.api.client.service.BinanceApiServiceGenerator
import okhttp3.WebSocketListener

class BinanceApiClientFactory private constructor(
    private val apiKey: String?,
    private val secret: String?,
    private val baseUrl: String
) {

    fun newSpotRestClient(): BinanceApiSpotRestClient = BinanceApiSpotRestClient(apiKey, secret, baseUrl)

    fun newMarginRestClient(): BinanceApiMarginRestClient = BinanceApiMarginRestClient(apiKey, secret, baseUrl)

    fun newMarketDataRestClient(): BinanceApiMarketDataRestClient =
        BinanceApiMarketDataRestClient(apiKey, secret, baseUrl)

    fun newWebSocketClient(listener: WebSocketListener): BinanceWebSocketClient =
        BinanceWebSocketClient(BinanceApiServiceGenerator.sharedClient, listener)

    fun newUnofficialClient(): BinanceApiUnofficialRestClient = BinanceApiUnofficialRestClient(baseUrl)

    companion object {

        /**
         * New instance with authentication.
         */
        fun newInstance(
            apiKey: String,
            secret: String,
            baseUrl: String = BinanceApiConstants.DEFAULT_API_BASE_URL
        ): BinanceApiClientFactory {
            return BinanceApiClientFactory(apiKey, secret, baseUrl)
        }

        /**
         * New instance without authentication.
         */
        fun newInstance(baseUrl: String = BinanceApiConstants.UNOFFICIAL_API_BASE_URL): BinanceApiClientFactory {
            return BinanceApiClientFactory(null, null, baseUrl)
        }
    }

}