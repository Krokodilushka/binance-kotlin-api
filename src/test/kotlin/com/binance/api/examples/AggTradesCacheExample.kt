package com.binance.api.examples

import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.BinanceApiClientFactory.Companion.newInstance
import com.binance.api.client.domain.event.AggTradeEvent
import com.binance.api.client.domain.market.AggTrade
import java.util.*

/**
 * Illustrates how to use the aggTrades event stream to create a local cache of trades for a symbol.
 */
class AggTradesCacheExample(symbol: String) {
    /**
     * Key is the aggregate trade id, and the value contains the aggregated trade data, which is
     * automatically updated whenever a new agg data stream event arrives.
     */
    private var aggTradesCache: MutableMap<Long, AggTrade>? = null

    /**
     * Initializes the aggTrades cache by using the REST API.
     */
    private fun initializeAggTradesCache(symbol: String) {
        val factory = newInstance()
        val client = factory.newRestClient()
        val aggTrades = client.getAggTrades(symbol.toUpperCase())
        aggTradesCache = HashMap()
        for (aggTrade in aggTrades!!) {
            aggTradesCache!![aggTrade.aggregatedTradeId] = aggTrade
        }
    }

    /**
     * Begins streaming of agg trades events.
     */
    private fun startAggTradesEventStreaming(symbol: String) {
        val factory = newInstance()
        val client = factory.newWebSocketClient()
        client.onAggTradeEvent(symbol.toLowerCase(), object : BinanceApiCallback<AggTradeEvent> {
            override fun onResponse(response: AggTradeEvent) {
                val aggregatedTradeId = response.aggregatedTradeId
                var updateAggTrade = aggTradesCache!![aggregatedTradeId]
                if (updateAggTrade == null) {
                    // new agg trade
                    updateAggTrade = AggTrade()
                }
                updateAggTrade.aggregatedTradeId = aggregatedTradeId
                updateAggTrade.price = response.price
                updateAggTrade.quantity = response.quantity
                updateAggTrade.firstBreakdownTradeId = response.firstBreakdownTradeId
                updateAggTrade.lastBreakdownTradeId = response.lastBreakdownTradeId
                updateAggTrade.isBuyerMaker = response.isBuyerMaker

                // Store the updated agg trade in the cache
                aggTradesCache!![aggregatedTradeId] = updateAggTrade
                println(updateAggTrade)
            }
        })
    }

    /**
     * @return an aggTrades cache, containing the aggregated trade id as the key,
     * and the agg trade data as the value.
     */
    fun getAggTradesCache(): Map<Long, AggTrade>? {
        return aggTradesCache
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AggTradesCacheExample("ETHBTC")
        }
    }

    init {
        initializeAggTradesCache(symbol)
        startAggTradesEventStreaming(symbol)
    }
}