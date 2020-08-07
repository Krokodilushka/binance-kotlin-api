package com.binance.api.client

import com.binance.api.client.impl.BinanceApiMarginRestClientImpl
import com.binance.api.client.impl.BinanceApiSpotRestClientImpl
import com.binance.api.client.impl.BinanceWebSocketClientImpl
import com.binance.api.client.service.BinanceApiServiceGenerator

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
        /**
         * API Key
         */
        private val apiKey: String?,
        /**
         * Secret.
         */
        private val secret: String?) {

    /**
     * Creates a new synchronous/blocking REST client.
     */
    fun newSpotRestClient(): BinanceApiSpotRestClient {
        return BinanceApiSpotRestClientImpl(apiKey, secret)
    }

    /**
     * Creates a new synchronous/blocking Margin REST client.
     */
    fun newMarginRestClient(): BinanceApiMarginRestClient {
        return BinanceApiMarginRestClientImpl(apiKey, secret)
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    fun newWebSocketClient(): BinanceWebSocketClient {
        return BinanceWebSocketClientImpl(BinanceApiServiceGenerator.sharedClient)
    }

    companion object {
        /**
         * New instance.
         *
         * @param apiKey the API key
         * @param secret the Secret
         * @return the binance api client factory
         */
        fun newInstance(apiKey: String, secret: String): BinanceApiClientFactory {
            return BinanceApiClientFactory(apiKey, secret)
        }

        /**
         * New instance without authentication.
         *
         * @return the binance api client factory
         */
        fun newInstance(): BinanceApiClientFactory {
            return BinanceApiClientFactory(null, null)
        }
    }

}