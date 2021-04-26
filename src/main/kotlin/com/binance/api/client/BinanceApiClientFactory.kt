package com.binance.api.client

import com.binance.api.client.impl.BinanceApiMarginRestClientImpl
import com.binance.api.client.impl.BinanceApiMarketDataRestClientImpl
import com.binance.api.client.impl.BinanceApiSpotRestClientImpl
import com.binance.api.client.impl.BinanceWebSocketClientImpl
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


    fun newSpotRestClient(): BinanceApiSpotRestClient = BinanceApiSpotRestClientImpl(apiKey, secret, baseUrl)

    fun newMarginRestClient(): BinanceApiMarginRestClient = BinanceApiMarginRestClientImpl(apiKey, secret, baseUrl)

    fun newMarketDataRestClient(): BinanceApiMarketDataRestClient =
        BinanceApiMarketDataRestClientImpl(apiKey, secret, baseUrl)

    fun newWebSocketClient(listener: WebSocketListener): BinanceWebSocketClient =
        BinanceWebSocketClientImpl(BinanceApiServiceGenerator.sharedClient, listener)

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