package com.binance.api.client

import com.binance.api.client.service.BinanceApiServiceGenerator
import okhttp3.WebSocketListener

/**
 * A factory for creating BinanceApi client objects.
 */
class BinanceApiClientFactory
/**
 * Instantiates a new binance api client factory.
 *
 * @param apiKey the API key
 * @param secret the Secret
 */
private constructor(
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

    companion object {
        /**
         * New instance.
         *
         * @param apiKey the API key
         * @param secret the Secret
         * @return the binance api client factory
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
         *
         * @return the binance api client factory
         */
        fun newInstance(baseUrl: String = BinanceApiConstants.DEFAULT_API_BASE_URL): BinanceApiClientFactory {
            return BinanceApiClientFactory(null, null, baseUrl)
        }
    }

}