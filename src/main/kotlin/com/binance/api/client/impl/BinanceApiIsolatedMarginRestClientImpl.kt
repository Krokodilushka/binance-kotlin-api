package com.binance.api.client.impl

import com.binance.api.client.BinanceApiIsolatedMarginRestClient

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 */
class BinanceApiIsolatedMarginRestClientImpl(apiKey: String?, secret: String?) : BinanceApiIsolatedMarginRestClient {
    private val binanceApiService = BinanceApiServiceGenerator.createService(BinanceApiService::class.java, apiKey, secret)

    // user stream endpoints
    override fun startUserDataStream(symbol: String): String {
        return BinanceApiServiceGenerator.executeSync(binanceApiService.startIsolatedMarginUserDataStream(symbol)).listenKey
    }

    override fun keepAliveUserDataStream(listenKey: String) {
        BinanceApiServiceGenerator.executeSync(binanceApiService.keepAliveIsolatedMarginUserDataStream(listenKey))
    }

}