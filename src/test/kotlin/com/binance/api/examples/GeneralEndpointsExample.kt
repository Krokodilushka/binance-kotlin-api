package com.binance.api.examples

import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.general.Asset
import com.binance.api.client.domain.general.FilterType

/**
 * Examples on how to use the general endpoints.
 */
class GeneralEndpointsExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = newInstance()
            val client = factory.newRestClient()

            // Test connectivity
            client.ping()

            // Check server time
            val serverTime = client.getServerTime()
            println(serverTime)

            // Exchange info
            val exchangeInfo = client.getExchangeInfo()
            println(exchangeInfo.timezone)
            println(exchangeInfo.symbols)

            // Obtain symbol information
            val symbolInfo = exchangeInfo.getSymbolInfo("ETHBTC")
            println(symbolInfo.status)
            val priceFilter = symbolInfo.getSymbolFilter(FilterType.PRICE_FILTER)
            println(priceFilter.minPrice)
            println(priceFilter.tickSize)

            // Obtain asset information
            val allAssets = client.getAllAssets()
            println(allAssets.stream().filter { asset: Asset -> asset.assetCode == "BNB" }.findFirst().get())
        }
    }
}