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
        /**
         * API Key
         */
        private val apiKey: String?,
        /**
         * Secret.
         */
        private val secret: String?) {


    fun newSpotRestClient() = BinanceApiSpotRestClientImpl(apiKey, secret)

    fun newMarginRestClient() = BinanceApiMarginRestClientImpl(apiKey, secret)

    fun newMarketDataRestClient() = BinanceApiMarketDataRestClientImpl(apiKey, secret)

    fun newWebSocketClient(listener: WebSocketListener) = BinanceWebSocketClientImpl(BinanceApiServiceGenerator.sharedClient, listener)

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