package com.binance.api.client

import com.binance.api.client.impl.*

/**
 * A factory for creating BinanceApi client objects.
 */
class BinanceApiClientFactory
/**
 * Instantiates a new binance api client factory.
 *
 * @param apiKey the API key
 * @param secret the Secret
 */ private constructor(
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
    fun newRestClient(): BinanceApiRestClient {
        return BinanceApiRestClientImpl(apiKey, secret)
    }

    /**
     * Creates a new synchronous/blocking Margin REST client.
     */
    fun newMarginRestClient(): BinanceApiMarginRestClient {
        return BinanceApiMarginRestClientImpl(apiKey, secret)
    }

    /**
     * Creates a new synchronous/blocking Margin REST client.
     */
    fun newIsolatedMarginRestClient(): BinanceApiIsolatedMarginRestClient {
        return BinanceApiIsolatedMarginRestClientImpl(apiKey, secret)
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    fun newWebSocketClient(): BinanceApiWebSocketClient {
        return BinanceApiWebSocketClientImpl(BinanceApiServiceGenerator.sharedClient)
    }

    companion object {
        /**
         * New instance.
         *
         * @param apiKey the API key
         * @param secret the Secret
         * @return the binance api client factory
         */
        fun newInstance(apiKey: String?, secret: String?): BinanceApiClientFactory {
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