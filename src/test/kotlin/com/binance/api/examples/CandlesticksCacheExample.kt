package com.binance.api.examples

import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.event.CandlestickEvent
import com.binance.api.client.domain.market.Candlestick
import com.binance.api.client.domain.market.CandlestickInterval
import java.util.*

/**
 * Illustrates how to use the klines/candlesticks event stream to create a local cache of bids/asks for a symbol.
 */
class CandlesticksCacheExample(symbol: String, interval: CandlestickInterval) {
    /**
     * Key is the start/open time of the candle, and the value contains candlestick date.
     */
    private var candlesticksCache: MutableMap<Long?, Candlestick>? = null

    /**
     * Initializes the candlestick cache by using the REST API.
     */
    private fun initializeCandlestickCache(symbol: String, interval: CandlestickInterval) {
        val factory = newInstance()
        val client = factory.newRestClient()
        val candlestickBars = client.getCandlestickBars(symbol.toUpperCase(), interval)
        candlesticksCache = TreeMap()
        for (candlestickBar in candlestickBars) {
            candlesticksCache!![candlestickBar.openTime] = candlestickBar
        }
    }

    /**
     * Begins streaming of depth events.
     */
    private fun startCandlestickEventStreaming(symbol: String, interval: CandlestickInterval) {
        val factory = newInstance()
        val client = factory.newWebSocketClient()
        client.onCandlestickEvent(symbol.toLowerCase(), interval, object : BinanceApiCallback<CandlestickEvent> {
            override fun onResponse(response: CandlestickEvent) {
                val openTime = response.openTime
                var updateCandlestick = candlesticksCache!![openTime]
                if (updateCandlestick == null) {
                    // new candlestick
                    updateCandlestick = Candlestick()
                }
                // update candlestick with the stream data
                updateCandlestick.openTime = response.openTime
                updateCandlestick.open = response.open
                updateCandlestick.low = response.low
                updateCandlestick.high = response.high
                updateCandlestick.close = response.close
                updateCandlestick.closeTime = response.closeTime
                updateCandlestick.volume = response.baseAssetVolume
                updateCandlestick.numberOfTrades = response.numberOfTrades
                updateCandlestick.quoteAssetVolume = response.quoteAssetVolume
                updateCandlestick.takerBuyQuoteAssetVolume = response.takerBuyQuoteAssetVolume
                updateCandlestick.takerBuyBaseAssetVolume = response.takerBuyQuoteAssetVolume

                // Store the updated candlestick in the cache
                candlesticksCache!![openTime] = updateCandlestick
                println(updateCandlestick)
            }
        })
    }

    /**
     * @return a klines/candlestick cache, containing the open/start time of the candlestick as the key,
     * and the candlestick data as the value.
     */
    fun getCandlesticksCache(): Map<Long?, Candlestick>? {
        return candlesticksCache
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CandlesticksCacheExample("ETHBTC", CandlestickInterval.ONE_MINUTE)
        }
    }

    init {
        initializeCandlestickCache(symbol, interval)
        startCandlestickEventStreaming(symbol, interval)
    }
}